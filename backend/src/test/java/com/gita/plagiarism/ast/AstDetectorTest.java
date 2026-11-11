package com.gita.plagiarism.ast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AstDetectorTest {

    private final AstDetector detector = new AstDetector();

    @Test
    void testIdenticalAstStructureWithRenamedVariables() {
        String a = "public class Knapsack { int solve(int[] w) { int s = 0; for(int i=0; i<w.length; i++) s+=w[i]; return s; } }";
        String b = "public class Packer { int calculate(int[] weights) { int total = 0; for(int idx=0; idx<weights.length; idx++) total+=weights[idx]; return total; } }";
        assertEquals(1.0, detector.similarity(a, b), 0.001);
    }
}