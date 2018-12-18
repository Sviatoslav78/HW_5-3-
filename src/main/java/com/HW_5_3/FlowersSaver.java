package com.HW_5_3;

import java.io.FileWriter;
import java.io.IOException;

public abstract class FlowersSaver {

    public static void save() {

        try(FileWriter writer = new FileWriter("proba.txt", false))
        {
            String text = "";

            for (int i = 0; i < FlowerStore.flowers.size(); i++) {
                text += FlowerStore.getFlowers().get(i).getName() + " ";
            }
            
            writer.write(text + '\n');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }


}
