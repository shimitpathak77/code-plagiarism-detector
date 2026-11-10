
package com.gita.plagiarism.preprocessing;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

public final class AstParser {

    static {
        StaticJavaParser.getParserConfiguration()
            .setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_21)
            .setAttributeComments(false);
    }

    private AstParser() {}

    /**
     * Parses Java source into an AST without attributing comments.
     */
    public static CompilationUnit parse(String sourceCode) {
        return StaticJavaParser.parse(sourceCode);
    }

    /** True if the code parses without errors. */
    public static boolean isParsable(String sourceCode) {
        try {
            StaticJavaParser.parse(sourceCode);
            return true;
        } catch (ParseProblemException e) {
            return false;
        }
    }
}