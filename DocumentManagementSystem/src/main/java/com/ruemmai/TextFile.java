package com.ruemmai;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.ruemmai.Attributes.PATH;

public class TextFile {
    private final Map<String, String> attributes = new HashMap<>();
    private final List<String> lines;

    public TextFile(final File file) throws IOException {
        this.attributes.put(PATH, file.getPath());
        this.lines = Files.readAllLines(Paths.get(file.getPath()));
    }

    void addLineSuffix(final String prefix, final String attributeName) {
        for(final String line: lines) {
            if (line.startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }

    int addLines(final int start, final Predicate<String> isEnd, final String attributeName) {
        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;
        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get(lineNumber);
            if (isEnd.test(line)) {
                break;
            }
            accumulator.append(line);
            accumulator.append("\n");
        }
        attributes.put(attributeName, accumulator.toString().trim());
        return lineNumber;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
