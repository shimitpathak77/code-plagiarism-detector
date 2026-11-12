package com.gita.plagiarism.eval;

public record EvalPair(
        String pairId, String fileA, String fileB,
        String codeA, String codeB, int label,
        String difficulty, String split
) {
    public boolean isPositive() { return label == 1; }
}