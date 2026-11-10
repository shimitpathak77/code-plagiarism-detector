package com.gita.plagiarism.preprocessing;

/**
 * One row of the labeled dataset, with both source files already loaded.
 *
 * @param pairId     unique id, e.g. SP-001
 * @param fileA      path of the first file, relative to the dataset folder
 * @param fileB      path of the second file, relative to the dataset folder
 * @param codeA      contents of fileA
 * @param codeB      contents of fileB
 * @param label      true if the pair is plagiarism, false otherwise
 * @param difficulty light, medium, heavy (positives) or unrelated, same_problem
 *                   (negatives)
 * @param split      "dev" (tune thresholds here) or "test" (report final
 *                   numbers here)
 */
public record LabeledPair(
        String pairId,
        String fileA,
        String fileB,
        String codeA,
        String codeB,
        boolean label,
        String difficulty,
        String split) {
}