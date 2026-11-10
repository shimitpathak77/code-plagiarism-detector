package com.gita.plagiarism.preprocessing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class TokenizerTest {

    @Test
    void renamedVariablesGiveSameTokens() {
        String a = "int sum = a + b; // add";
        String b = "int total = x + y; /* combine */";
        assertEquals(Tokenizer.tokenize(a), Tokenizer.tokenize(b));
    }

    @Test
    void commentsAreDropped() {
        assertEquals(List.of("int", "ID", ";"), Tokenizer.tokenize("int x; // note\n/* more\nlines */"));
    }

    @Test
    void literalsAreNormalized() {
        assertEquals(List.of("ID", "=", "STR", ";", "ID", "=", "NUM", ";", "ID", "=", "CHAR", ";"),
            Tokenizer.tokenize("s = \"hi\"; n = 42; c = 'x';"));
    }

    @Test
    void keywordsAndOperatorsAreKept() {
        assertEquals(List.of("if", "(", "ID", "<=", "NUM", ")", "return", ";"),
            Tokenizer.tokenize("if (i <= 10) return;"));
    }

    @Test
    void ngrams() {
        List<String> t = List.of("a", "b", "c", "d");
        assertEquals(List.of("a b c", "b c d"), Tokenizer.generateNGrams(t, 3));
        assertEquals(List.of(), Tokenizer.generateNGrams(t, 5));
        assertThrows(IllegalArgumentException.class, () -> Tokenizer.generateNGrams(t, 0));
    }

    @Test
    void emptyInput() {
        assertFalse(Tokenizer.tokenize("").iterator().hasNext());
    }
}