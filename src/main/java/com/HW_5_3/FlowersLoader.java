package com.HW_5_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public abstract class FlowersLoader {


    public static String load() throws FileNotFoundException {

        String flowers = "";

        FileReader file = new FileReader("proba.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                flowers += scanner.nextLine();
            }
            scanner.close();
            return flowers;

    }
}
