package com.gita.plagiarism.ast;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;
import com.gita.plagiarism.detector.Detector;

import java.util.*;

public class AstDetector implements Detector {

    private final JavaParser parser = new JavaParser();

    @Override
    public String name() {
        return "AST-Based Detector (Subtree Hashing)";
    }

    @Override
    public double similarity(String codeA, String codeB) {
        if (codeA == null && codeB == null) return 1.0;
        if (codeA == null || codeB == null) return 0.0;

        Node rootA = parse(codeA);
        Node rootB = parse(codeB);

        if (rootA == null && rootB == null) return 1.0;
        if (rootA == null || rootB == null) return 0.0;

        Map<String, Integer> bagA = new HashMap<>();
        Map<String, Integer> bagB = new HashMap<>();

        buildSignature(rootA, bagA);
        buildSignature(rootB, bagB);

        return computeMultisetJaccard(bagA, bagB);
    }

    private Node parse(String code) {
        if (code.isBlank()) return null;
        ParseResult<CompilationUnit> res = parser.parse(code);
        if (res.isSuccessful() && res.getResult().isPresent()) return res.getResult().get();

        // Fallback: wrap snippet in dummy class if snippet is just method/statements
        ParseResult<CompilationUnit> wrapped = parser.parse("class Dummy { " + code + " }");
        return (wrapped.isSuccessful() && wrapped.getResult().isPresent()) ? wrapped.getResult().get() : null;
    }

    private String buildSignature(Node node, Map<String, Integer> bag) {
        if (node instanceof Comment) return "";

        String type = node.getClass().getSimpleName();
        List<String> children = new ArrayList<>();
        for (Node child : node.getChildNodes()) {
            if (!(child instanceof Comment)) {
                String sig = buildSignature(child, bag);
                if (!sig.isEmpty()) children.add(sig);
            }
        }

        String signature = type + (children.isEmpty() ? "" : "(" + String.join(",", children) + ")");
        bag.put(signature, bag.getOrDefault(signature, 0) + 1);
        return signature;
    }

    private double computeMultisetJaccard(Map<String, Integer> a, Map<String, Integer> b) {
        if (a.isEmpty() && b.isEmpty()) return 1.0;
        if (a.isEmpty() || b.isEmpty()) return 0.0;

        Set<String> allKeys = new HashSet<>(a.keySet());
        allKeys.addAll(b.keySet());

        int minSum = 0, maxSum = 0;
        for (String k : allKeys) {
            int countA = a.getOrDefault(k, 0);
            int countB = b.getOrDefault(k, 0);
            minSum += Math.min(countA, countB);
            maxSum += Math.max(countA, countB);
        }
        return maxSum == 0 ? 1.0 : (double) minSum / maxSum;
    }
}