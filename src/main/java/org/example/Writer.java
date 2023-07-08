package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    private static String outputPath;
    private static BufferedWriter bufferedWriter = null;

    public static void write(List<String> inputList, String fileName) {

        setFileName(fileName);

        for (String string : inputList) {
            try {
                FileWriter fileWriter = new FileWriter(outputPath, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void setFileName(String fileName) {
        outputPath = System.getProperty("user.dir") + "\\" + fileName + "_column_to_row" + ".txt";
    }

    public static String getFileName() {
        return outputPath;
    }
}
