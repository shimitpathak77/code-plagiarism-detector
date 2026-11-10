package com.gita.plagiarism.preprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Turns Java source into a normalized token list.
 *
 * <ul>
 * <li>Comments and whitespace are dropped.</li>
 * <li>String / char / number literals become STR / CHAR / NUM.</li>
 * <li>Identifiers (variable, method, class names) become ID, which is what
 * defeats "just rename the variables" plagiarism.</li>
 * <li>Keywords, operators and punctuation are kept as they are.</li>
 * </ul>
 *
 * This is shared preprocessing: every detector that needs tokens must use it,
 * so the Phase 3 comparison is fair.
 */
public final class Tokenizer {

    private Tokenizer() {
    }

    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum",
            "extends", "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new",
            "package", "private", "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while", "true", "false", "null"));

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "//[^\\n]*" // line comment
                    + "|/\\*[\\s\\S]*?\\*/" // block comment
                    + "|\"(?:\\\\.|[^\"\\\\\\n])*\"" // string literal
                    + "|'(?:\\\\.|[^'\\\\\\n])*'" // char literal
                    + "|\\b\\d+\\.?\\d*[fFdDlL]?\\b" // number
                    + "|[A-Za-z_$][A-Za-z0-9_$]*" // identifier or keyword
                    + "|[{}()\\[\\];,.]" // punctuation
                    + "|[+\\-*/%=<>!&|^~?:]+" // operators
    );

    private static final Pattern NUMBER = Pattern.compile("\\d+\\.?\\d*[fFdDlL]?");
    private static final Pattern WORD = Pattern.compile("[A-Za-z_$][A-Za-z0-9_$]*");

    /** Normalized tokens of the given source code. */
    public static List<String> tokenize(String sourceCode) {
        List<String> tokens = new ArrayList<>();
        Matcher m = TOKEN_PATTERN.matcher(sourceCode);
        while (m.find()) {
            String raw = m.group();
            if (raw.startsWith("//") || raw.startsWith("/*"))
                continue;
            if (raw.startsWith("\"")) {
                tokens.add("STR");
                continue;
            }
            if (raw.startsWith("'")) {
                tokens.add("CHAR");
                continue;
            }
            if (NUMBER.matcher(raw).matches()) {
                tokens.add("NUM");
                continue;
            }
            if (WORD.matcher(raw).matches()) {
                tokens.add(KEYWORDS.contains(raw) ? raw : "ID");
                continue;
            }
            tokens.add(raw);
        }
        return tokens;
    }

    /** All contiguous groups of n tokens, joined with a space. */
    public static List<String> generateNGrams(List<String> tokens, int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n must be positive");
        List<String> ngrams = new ArrayList<>();
        for (int i = 0; i + n <= tokens.size(); i++) {
            ngrams.add(String.join(" ", tokens.subList(i, i + n)));
        }
        return ngrams;
    }
}