package com.HW_9;

import java.io.*;
import java.net.URL;

public class Main {


    public static void main(String[] args) {


    }

    public static void downloadFile(final String pathToFile, final String urlString) throws IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(pathToFile);

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
                System.out.println("File is successfully downloaded!");
            }
        }
    }
}
