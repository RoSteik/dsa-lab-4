package ua.lviv.iot.manager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TilesReader {
    public static char[][] getTilesFrom(String path) {
        int row;
        int column;

        String text = getTextFromFile(path);
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);

        matcher.find();
        column = Integer.parseInt(matcher.group());

        matcher.find();
        row = Integer.parseInt(matcher.group());
        char[][] tiles = new char[row][column];


        pattern = Pattern.compile(".*\\d");
        matcher = pattern.matcher(text);
        matcher.find();
        text = text.substring(matcher.end() + 1);

        pattern = Pattern.compile("\\w");
        matcher = pattern.matcher(text);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matcher.find();
                tiles[i][j] = matcher.group().charAt(0);

            }
        }

        return tiles;
    }

    private static String getTextFromFile(String path) {
        File file = new File(path);
        String text = null;
        try (Scanner scanner = new Scanner(file)) {
            StringBuilder result = new StringBuilder();
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
            text = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

}
