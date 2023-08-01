package com.ruemmai;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.ruemmai.Attributes.*;

public class InvoiceImporter implements Importer{
    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix("", PATIENT);
        textFile.addLineSuffix("Amount:", AMOUNT);
        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "INVOICE");

        return new Document(attributes);
    }
}
