package com.gita.plagiarism.eval;

import com.gita.plagiarism.ast.AstDetector;
import com.gita.plagiarism.preprocessing.Tokenizer;
import com.gita.plagiarism.token.TokenDetector;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FeatureExporter {

    public static void main(String[] args) throws Exception {
        System.out.println("Extracting features for Phase 4 ML training...");

        Path root = DatasetLoader.locateDatasetRoot();
        DatasetLoader loader = new DatasetLoader(root);
        List<EvalPair> positives = loader.loadAllLabeledPairs();
        List<EvalPair> negatives = new NegativePairGenerator().generateNegativePairs(positives, root);

        List<EvalPair> allPairs = new ArrayList<>(positives);
        allPairs.addAll(negatives);

        TokenDetector tokenDetector = new TokenDetector(3);
        AstDetector astDetector = new AstDetector();

        // Output destination: ml-service/data/features.csv
        Path outDir = root.getParent().resolve("ml-service").resolve("data");
        Files.createDirectories(outDir);
        Path csvPath = outDir.resolve("features.csv");

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvPath.toFile()))) {
            // CSV Header
            writer.println("pair_id,token_sim,ast_sim,token_count_ratio,line_count_ratio,difficulty,split,label");

            for (EvalPair pair : allPairs) {
                String codeA = pair.codeA();
                String codeB = pair.codeB();

                // Feature 1: Token Similarity
                double tokenSim = tokenDetector.similarity(codeA, codeB);

                // Feature 2: AST Similarity
                double astSim = astDetector.similarity(codeA, codeB);

                // Feature 3: Token Count Ratio (min / max)
                List<String> tokensA = Tokenizer.tokenize(codeA);
                List<String> tokensB = Tokenizer.tokenize(codeB);
                double maxTokens = Math.max(tokensA.size(), tokensB.size());
                double tokenRatio = maxTokens == 0 ? 1.0 : (double) Math.min(tokensA.size(), tokensB.size()) / maxTokens;

                // Feature 4: Line Count Ratio
                long linesA = codeA.lines().count();
                long linesB = codeB.lines().count();
                double maxLines = Math.max(linesA, linesB);
                double lineRatio = maxLines == 0 ? 1.0 : (double) Math.min(linesA, linesB) / maxLines;

                writer.println(String.format(Locale.US,
                        "%s,%.4f,%.4f,%.4f,%.4f,%s,%s,%d",
                        pair.pairId(),
                        tokenSim,
                        astSim,
                        tokenRatio,
                        lineRatio,
                        pair.difficulty(),
                        pair.split(),
                        pair.label()
                ));
            }
        }

        System.out.printf("Successfully exported %d feature rows to: %s\n", allPairs.size(), csvPath.toAbsolutePath());
    }
}