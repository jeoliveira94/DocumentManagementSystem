package com.ruemmai;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.ruemmai.Attributes.*;

public class ReportImporter implements Importer {
    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix("Patient:", PATIENT);
        textFile.addLines(2, String::isEmpty, BODY);
        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "REPORT");
        return new Document(attributes);
    }
}
