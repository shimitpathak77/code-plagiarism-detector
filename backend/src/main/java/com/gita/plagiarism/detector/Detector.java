package com.gita.plagiarism.detector;

public interface Detector {
    String name();

    /** 0.0 = unrelated, 1.0 = identical */
    double similarity(String codeA, String codeB);
}