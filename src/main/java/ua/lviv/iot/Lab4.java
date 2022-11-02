package ua.lviv.iot;

import ua.lviv.iot.manager.Solver;
import ua.lviv.iot.manager.TilesReader;

public class Lab4 {
    public static void main(String[] args) {

        char [][] tiles = TilesReader.getTilesFrom("src/main/resources/ijones.in2.txt");
        Solver.solve(tiles);


    }

}
