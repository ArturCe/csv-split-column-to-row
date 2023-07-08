package org.example;

import java.io.File;
import java.util.List;

public class Main {

    private static String delimiter = "[0-9][0-9]:[0-9][0-9]:[0-9][0-9]";
    private static String fileName;
    private static final String DIRECTORY = "user.dir";

    public static void main(String[] args) {

        if (args.length > 0 && args[0].length() > 0) {
            delimiter = args[0];
        }

        findFiles();

        if (fileName != null) {
            List<String> inputFileContent = Reader.readFileContent(System.getProperty(DIRECTORY) + "\\" + fileName);

            for (String string : inputFileContent) {
                Rebuilder.split(string, delimiter);
            }

            List<String> result = Rebuilder.getResult();
            Writer.write(result, fileName.replace(".csv", ""));
            System.out.println("\nZapisano plik " + Writer.getOutputFilePath());

        } else {
            System.out.println("Brak plikow do procesowania w lokalizacji " + System.getProperty(DIRECTORY));
            System.exit(0);
        }
    }

    private static void findFiles() {
        File folder = new File(System.getProperty(DIRECTORY));
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (file.getName().contains(".csv")) {
                    fileName = file.getName();
                    break;
                }
            }
        }
    }
}