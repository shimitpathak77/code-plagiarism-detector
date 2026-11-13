package com.gita.plagiarism.eval;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.gita.plagiarism.ast.AstDetector;
import com.gita.plagiarism.token.TokenDetector;

class EvaluationRunnerTest {
    @Test
    void runBenchmark() throws Exception {
       // If your method is runBenchmark:
       EvaluationRunner.runBenchmark(List.of(new TokenDetector(3),new AstDetector()));
    }
    @Test
    void exportFeatures() throws Exception {
        FeatureExporter.main(new String[0]);
    }
}