package com.gita.plagiarism.preprocessing;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.comments.Comment;

import java.util.ArrayList;

/**
 * Thin wrapper around JavaParser so every detector parses code the same way.
 */
public final class AstParser {

    static {
        StaticJavaParser.getParserConfiguration()
            .setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_17);
    }

    private AstParser() {}

    /**
     * Parses Java source into an AST with all comments removed.
     *
     * @throws ParseProblemException if the code is not valid Java
     */
    public static CompilationUnit parse(String sourceCode) {
        CompilationUnit cu = StaticJavaParser.parse(sourceCode);
        // copy first: removing while iterating would break the list
        new ArrayList<>(cu.getAllContainedComments()).forEach(Comment::remove);
        return cu;
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