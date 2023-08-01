package com.ruemmai;

import java.io.IOException;

public class Main {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) {
        final DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem();

        try {
            documentManagementSystem.importFile(RESOURCES + "jose-oliveira.letter");
            documentManagementSystem.importFile(RESOURCES + "jose-oliveira.invoice");
            documentManagementSystem.importFile(RESOURCES + "jose-oliveira.report");
            documentManagementSystem.importFile(RESOURCES + "jose-oliveira.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnknownFileTypeException e) {
            throw new RuntimeException(e);
        }
    }
}
