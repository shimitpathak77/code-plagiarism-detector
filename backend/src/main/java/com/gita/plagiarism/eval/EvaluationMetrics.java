package com.gita.plagiarism.eval;

import java.util.Map;

public record EvaluationMetrics(
        String detectorName, String split, double threshold,
        int tp, int fp, int tn, int fn,
        double accuracy, double precision, double recall, double f1,
        Map<String, Double> recallByDifficulty, long durationMs
) {}