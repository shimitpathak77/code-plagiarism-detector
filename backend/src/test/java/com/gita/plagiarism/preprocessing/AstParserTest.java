package com.gita.plagiarism.preprocessing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javaparser.ast.CompilationUnit;
import org.junit.jupiter.api.Test;

class AstParserTest {

    private static final String CODE =
        "public class T { /* c */ int add(int a, int b) { return a + b; } // end\n}";

    @Test
    void parsesValidCode() {
        CompilationUnit cu = AstParser.parse(CODE);
        assertTrue(cu.getClassByName("T").isPresent());
    }

    @Test
    void commentsAreRemoved() {
        assertTrue(AstParser.parse(CODE).getAllContainedComments().isEmpty());
    }

    @Test
    void detectsInvalidCode() {
        assertTrue(AstParser.isParsable(CODE));
        assertFalse(AstParser.isParsable("public class T { int x = ; "));
    }
}