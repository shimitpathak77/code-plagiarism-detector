package com.gita.plagiarism.eval;

import com.gita.plagiarism.detector.Detector;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class EvaluationRunner {

    public static void runBenchmark(List<Detector> detectors) throws Exception {
        Path root = DatasetLoader.locateDatasetRoot();
        DatasetLoader loader = new DatasetLoader(root);
        List<EvalPair> positives = loader.loadAllLabeledPairs();
        List<EvalPair> negatives = new NegativePairGenerator().generateNegativePairs(positives, root);

        List<EvalPair> all = new ArrayList<>(positives);
        all.addAll(negatives);

        List<EvalPair> dev = all.stream().filter(p -> "dev".equalsIgnoreCase(p.split())).toList();
        List<EvalPair> test = all.stream().filter(p -> "test".equalsIgnoreCase(p.split())).toList();

        System.out.println("Dev set: " + dev.size() + " pairs | Test set: " + test.size() + " pairs\n");

        StringBuilder report = new StringBuilder("# Phase 1 & 2 Evaluation Results\n\n");
        report.append("| Detector | Threshold | Precision | Recall | F1 Score | Accuracy | Light | Medium | Heavy | Time (ms) |\n|---|---|---|---|---|---|---|---|---|---|\n");

        for (Detector detector : detectors) {
            // 1. Tune threshold on DEV
            double bestT = 0.50, bestF1 = -1.0;
            for (double t = 0.10; t <= 0.90; t += 0.05) {
                EvaluationMetrics m = evaluate(detector, dev, t);
                if (m.f1() > bestF1) { bestF1 = m.f1(); bestT = t; }
            }

            // 2. Evaluate on TEST
            EvaluationMetrics tm = evaluate(detector, test, bestT);
            System.out.printf("[%s] Test F1: %.4f (Precision: %.2f%%, Recall: %.2f%%)\n",
                    tm.detectorName(), tm.f1(), tm.precision() * 100, tm.recall() * 100);

            report.append(String.format(Locale.US, "| %s | %.2f | %.4f | %.4f | %.4f | %.4f | %.2f | %.2f | %.2f | %d |\n",
                    tm.detectorName(), tm.threshold(), tm.precision(), tm.recall(), tm.f1(), tm.accuracy(),
                    tm.recallByDifficulty().get("light"), tm.recallByDifficulty().get("medium"), tm.recallByDifficulty().get("heavy"),
                    tm.durationMs()));
        }

        Path outDir = root.getParent().resolve("docs").resolve("results");
        Files.createDirectories(outDir);
        Files.writeString(outDir.resolve("phase1_eval_results.md"), report.toString());
        System.out.println("\nResults saved to docs/results/phase1_eval_results.md");
    }

    public static EvaluationMetrics evaluate(Detector detector, List<EvalPair> pairs, double threshold) {
        long start = System.currentTimeMillis();
        int tp = 0, fp = 0, tn = 0, fn = 0;
        Map<String, Integer> posTotal = new HashMap<>(), posDetected = new HashMap<>();

        for (EvalPair p : pairs) {
            boolean pred = detector.similarity(p.codeA(), p.codeB()) >= threshold;
            if (p.isPositive()) {
                posTotal.put(p.difficulty(), posTotal.getOrDefault(p.difficulty(), 0) + 1);
                if (pred) { tp++; posDetected.put(p.difficulty(), posDetected.getOrDefault(p.difficulty(), 0) + 1); }
                else fn++;
            } else {
                if (pred) fp++; else tn++;
            }
        }

        Map<String, Double> recallDiff = new HashMap<>();
        for (String d : List.of("light", "medium", "heavy")) {
            int tot = posTotal.getOrDefault(d, 0);
            recallDiff.put(d, tot == 0 ? 0.0 : (double) posDetected.getOrDefault(d, 0) / tot);
        }

        int total = tp + fp + tn + fn;
        double acc = total == 0 ? 0.0 : (double) (tp + tn) / total;
        double prec = (tp + fp) == 0 ? 0.0 : (double) tp / (tp + fp);
        double rec = (tp + fn) == 0 ? 0.0 : (double) tp / (tp + fn);
        double f1 = (prec + rec) == 0.0 ? 0.0 : 2 * prec * rec / (prec + rec);

        return new EvaluationMetrics(detector.name(), pairs.get(0).split(), threshold, tp, fp, tn, fn, acc, prec, rec, f1, recallDiff, System.currentTimeMillis() - start);
    }
}