package ua.lviv.iot.manager;

import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {

    public static void writeToFile(Integer outPut) {
        try (FileWriter result = new FileWriter("src/main/resources/ijones.out.txt")) {
            result.write(outPut.toString());
            System.out.println(outPut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
