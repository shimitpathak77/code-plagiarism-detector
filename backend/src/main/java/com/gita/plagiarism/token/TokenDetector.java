package com.gita.plagiarism.token;

import com.gita.plagiarism.detector.Detector;
import com.gita.plagiarism.preprocessing.Tokenizer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TokenDetector implements Detector {

    private final int nGramSize;

    public TokenDetector() {
        this(3); // default trigrams
    }

    public TokenDetector(int nGramSize) {
        this.nGramSize = nGramSize;
    }

    @Override
    public String name() {
        return "Token-Based Detector (n=" + nGramSize + ")";
    }

    @Override
    public double similarity(String codeA, String codeB) {
        if (codeA == null && codeB == null) return 1.0;
        if (codeA == null || codeB == null) return 0.0;

        List<String> tokensA = Tokenizer.tokenize(codeA);
        List<String> tokensB = Tokenizer.tokenize(codeB);

        if (tokensA.isEmpty() && tokensB.isEmpty()) return 1.0;
        if (tokensA.isEmpty() || tokensB.isEmpty()) return 0.0;

        int effectiveN = (tokensA.size() < nGramSize || tokensB.size() < nGramSize) ? 1 : nGramSize;
        Set<String> setA = new HashSet<>(Tokenizer.generateNGrams(tokensA, effectiveN));
        Set<String> setB = new HashSet<>(Tokenizer.generateNGrams(tokensB, effectiveN));

        if (setA.isEmpty() || setB.isEmpty()) return 0.0;

        int intersection = 0;
        for (String gram : setA) {
            if (setB.contains(gram)) intersection++;
        }

        int union = setA.size() + setB.size() - intersection;
        return union == 0 ? 1.0 : (double) intersection / union;
    }
}