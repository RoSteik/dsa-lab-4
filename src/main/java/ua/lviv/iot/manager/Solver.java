package ua.lviv.iot.manager;

import java.util.LinkedList;

public class Solver {

    public static void solve(char[][] tiles) {
        int result = 0;
        int row = tiles.length;
        int column = tiles[0].length;

        if (row > 1) {
            result += numberOfPath(column - 1, 0, tiles);
        }
        result += numberOfPath(column - 1, row - 1, tiles);

        ResultWriter.writeToFile(result);
    }

    private static int numberOfPath(int x, int y, char[][] tiles) {
        if (x == 0) {
            return 1;
        } else {
            int result = 0;
            LinkedList<int[]> teleports = numberOfTeleports(x, y, tiles);

            for (int[] point : teleports) {
                result += numberOfPath(point[0], point[1], tiles);
            } // кількість проходів через телепорти

            if (tiles[y][x] != tiles[y][x - 1]) {
                result += numberOfPath(x - 1, y, tiles);
            } // якшо сусід

            return result;
        }

    }

    private static LinkedList<int[]> numberOfTeleports(int x, int y, char[][] tiles) {
        LinkedList<int[]> resultList = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[j][i] == tiles[y][x]) {
                    resultList.add(new int[]{i, j});
                }
            }
        }

        return resultList;
    }

}
