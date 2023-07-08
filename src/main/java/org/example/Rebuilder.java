package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rebuilder {

    private static ArrayList<Integer> indexList = new ArrayList<>();
    private static ArrayList<String> result = new ArrayList<>();

    public static List<String> getResult() {
        return result;
    }

    public static void split(String text, String regex) {

        if (!indexList.isEmpty()) {
            indexList.clear();
        }

        setIndexList(text, regex);

        if (indexList.isEmpty()) {
            result.add(text);
        }

        int startIndex;
        int endIndex;

        for (int i = 0; i < indexList.size(); i++) {

            startIndex = indexList.get(i);

            if (i < indexList.size() - 1) {
                endIndex = indexList.get(i + 1);
            } else {
                endIndex = text.length();
            }

            result.add(text.substring(startIndex, endIndex));
        }
    }

    public static void setIndexList(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            indexList.add(matcher.start());
        }
    }
}
