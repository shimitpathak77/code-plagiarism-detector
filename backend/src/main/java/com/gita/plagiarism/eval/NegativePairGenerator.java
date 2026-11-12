package com.gita.plagiarism.eval;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class NegativePairGenerator {
    public List<EvalPair> generateNegativePairs(List<EvalPair> positivePairs, Path root) throws IOException {
        Map<String, Set<String>> originalsBySplit = Map.of(
                "dev", new LinkedHashSet<>(),
                "test", new LinkedHashSet<>()
        );

        for (EvalPair p : positivePairs) {
            if (originalsBySplit.containsKey(p.split())) originalsBySplit.get(p.split()).add(p.fileA());
        }

        List<EvalPair> negatives = new ArrayList<>();
        for (var entry : originalsBySplit.entrySet()) {
            String split = entry.getKey();
            List<String> list = new ArrayList<>(entry.getValue());
            long targetCount = positivePairs.stream().filter(p -> p.split().equalsIgnoreCase(split)).count();

            int count = 0;
            for (int i = 0; i < list.size() && count < targetCount; i++) {
                for (int j = i + 1; j < list.size() && count < targetCount; j++) {
                    String fileA = list.get(i);
                    String fileB = list.get(j);
                    negatives.add(new EvalPair(
                            "NEG-" + split.toUpperCase() + "-" + (++count),
                            fileA, fileB,
                            Files.readString(root.resolve(fileA)),
                            Files.readString(root.resolve(fileB)),
                            0, "none", split
                    ));
                }
            }
        }
        return negatives;
    }
}