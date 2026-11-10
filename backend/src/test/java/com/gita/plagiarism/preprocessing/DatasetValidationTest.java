package com.gita.plagiarism.preprocessing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * Guards the shared dataset: labels must be well formed, referenced files must
 * exist, and every .java file must parse. Fails with a list of the broken files.
 * Passes while the dataset is still empty.
 */
class DatasetValidationTest {

    @Test
    void labelsAreWellFormedAndFilesExist() {
        // load() throws with file name and line number on any malformed row
        DatasetLoader.load();
    }

    @Test
    void everyDatasetFileParses() throws IOException {
        Path root = DatasetLoader.findDatasetDir();
        List<String> broken = new ArrayList<>();
        for (String sub : List.of("originals", "plagiarized")) {
            Path dir = root.resolve(sub);
            if (!Files.isDirectory(dir)) continue;
            try (Stream<Path> files = Files.walk(dir)) {
                for (Path f : files.filter(p -> p.toString().endsWith(".java")).toList()) {
                    String code = Files.readString(f, StandardCharsets.UTF_8);
                    if (!AstParser.isParsable(code)) {
                        broken.add(root.relativize(f).toString());
                    }
                }
            }
        }
        assertTrue(broken.isEmpty(), "These dataset files do not parse: " + broken);
    }
}