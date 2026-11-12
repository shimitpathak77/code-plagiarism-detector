package com.gita.plagiarism.eval;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DatasetLoader {
    private final Path datasetRoot;

    public DatasetLoader(Path datasetRoot) { this.datasetRoot = datasetRoot; }

    public static Path locateDatasetRoot() {
        if (Files.exists(Path.of("dataset"))) return Path.of("dataset").toAbsolutePath().normalize();
        if (Files.exists(Path.of("../dataset"))) return Path.of("../dataset").toAbsolutePath().normalize();
        throw new IllegalStateException("Could not find dataset directory.");
    }

    public List<EvalPair> loadAllLabeledPairs() throws Exception {
        Path labelsDir = datasetRoot.resolve("labels");
        List<EvalPair> pairs = new ArrayList<>();
        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).setTrim(true).build();

        try (var stream = Files.newDirectoryStream(labelsDir, "*.csv")) {
            for (Path csv : stream) {
                try (Reader in = new FileReader(csv.toFile())) {
                    for (CSVRecord rec : format.parse(in)) {
                        String fileA = rec.get("file_a");
                        String fileB = rec.get("file_b");
                        String codeA = Files.readString(datasetRoot.resolve(fileA));
                        String codeB = Files.readString(datasetRoot.resolve(fileB));
                        pairs.add(new EvalPair(
                                rec.get("pair_id"), fileA, fileB, codeA, codeB,
                                Integer.parseInt(rec.get("label")), rec.get("difficulty"), rec.get("split")
                        ));
                    }
                }
            }
        }
        return pairs;
    }
}