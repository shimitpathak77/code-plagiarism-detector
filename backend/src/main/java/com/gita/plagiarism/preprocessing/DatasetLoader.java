package com.gita.plagiarism.preprocessing;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Loads every labels CSV in dataset/labels/ and reads the referenced files.
 *
 * Expected CSV header:
 * pair_id,file_a,file_b,label,difficulty,split
 * label is 1 (plagiarism) or 0 (not). File paths are relative to the dataset
 * folder.
 * Paths must not contain commas.
 */
public final class DatasetLoader {

    private DatasetLoader() {
    }

    /**
     * Finds the dataset folder: -Ddataset.dir if set, otherwise ./dataset,
     * otherwise ../dataset (so it works from the repo root and from backend/).
     */
    public static Path findDatasetDir() {
        String override = System.getProperty("dataset.dir");
        List<Path> candidates = new ArrayList<>();
        if (override != null)
            candidates.add(Path.of(override));
        candidates.add(Path.of("dataset"));
        candidates.add(Path.of("..", "dataset"));
        for (Path p : candidates) {
            if (Files.isDirectory(p.resolve("labels")))
                return p.toAbsolutePath().normalize();
        }
        throw new IllegalStateException("dataset folder not found; tried " + candidates);
    }

    public static List<LabeledPair> load() {
        return load(findDatasetDir());
    }

    public static List<LabeledPair> load(Path datasetDir) {
        List<LabeledPair> pairs = new ArrayList<>();
        try (Stream<Path> files = Files.list(datasetDir.resolve("labels"))) {
            List<Path> csvs = files
                    .filter(f -> f.getFileName().toString().endsWith(".csv"))
                    .sorted()
                    .toList();
            for (Path csv : csvs) {
                pairs.addAll(loadCsv(datasetDir, csv));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return pairs;
    }

    private static List<LabeledPair> loadCsv(Path datasetDir, Path csv) throws IOException {
        List<LabeledPair> result = new ArrayList<>();
        List<String> lines = Files.readAllLines(csv, StandardCharsets.UTF_8);
        for (int i = 1; i < lines.size(); i++) { // line 0 is the header
            String line = lines.get(i).trim();
            if (line.isEmpty())
                continue;
            String[] c = Arrays.stream(line.split(",", -1)).map(String::trim).toArray(String[]::new);
            if (c.length != 6) {
                throw new IllegalArgumentException(csv.getFileName() + " line " + (i + 1)
                        + ": expected 6 columns but found " + c.length);
            }
            if (!c[3].equals("0") && !c[3].equals("1")) {
                throw new IllegalArgumentException(csv.getFileName() + " line " + (i + 1)
                        + ": label must be 0 or 1, got '" + c[3] + "'");
            }
            if (!c[5].equals("dev") && !c[5].equals("test")) {
                throw new IllegalArgumentException(csv.getFileName() + " line " + (i + 1)
                        + ": split must be dev or test, got '" + c[5] + "'");
            }
            result.add(new LabeledPair(
                    c[0], c[1], c[2],
                    read(datasetDir, c[1], csv, i + 1),
                    read(datasetDir, c[2], csv, i + 1),
                    c[3].equals("1"), c[4], c[5]));
        }
        return result;
    }

    private static String read(Path datasetDir, String relative, Path csv, int lineNo) throws IOException {
        Path p = datasetDir.resolve(relative);
        if (!Files.isRegularFile(p)) {
            throw new IllegalArgumentException(csv.getFileName() + " line " + lineNo
                    + ": file not found: " + relative);
        }
        return Files.readString(p, StandardCharsets.UTF_8);
    }
}