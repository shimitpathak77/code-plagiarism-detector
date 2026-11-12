package com.gita.plagiarism.token;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TokenDetectorTest {

    private final TokenDetector detector = new TokenDetector(3);

    @Test
    void testRenamedVariablesGivesHighSimilarity() {
        String codeA = "public class A { public int sum(int x, int y) { return x + y; } }";
        String codeB = "public class B { public int add(int first, int second) { return first + second; } }";
        assertTrue(detector.similarity(codeA, codeB) >= 0.90);
    }

    @Test
    void testUnrelatedCodeGivesLowSimilarity() {
        String codeA = "public class A { void sort(int[] a) { for(int i=0; i<a.length; i++); } }";
        String codeB = "public class B { String greet() { return \"hello world\"; } }";
        assertTrue(detector.similarity(codeA, codeB) < 0.30);
    }
}