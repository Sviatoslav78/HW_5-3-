package com.HW_5_3;

import java.util.ArrayList;

import static java.lang.Math.*;

public class FlowerStore {

    private static int wallet;

    static ArrayList<Flowers> flowers = new ArrayList<>();

    public static ArrayList<Flowers> getFlowers() {
        return flowers;
    }

    public static int getWallet() {
        return wallet;
    }

    public static void showFlowers() {
        for (int i = 0; i < flowers.size(); i++) {
            System.out.print(flowers.get(i).name + ", ");
        }
    }

    public static ArrayList<Flowers> sell(int r, int c, int t) {

        flowers.clear();

        for (int i = 0; i < r; i++) {
            flowers.add(new Rose());
            wallet += Rose.getPrice();
        }
        for (int i = 0; i < c; i++) {
            flowers.add(new Chamomile());
            wallet += Chamomile.getPrice();
        }
        for (int i = 0; i < t; i++) {
            flowers.add(new Tulip());
            wallet += Tulip.getPrice();
        }

        return flowers;
    }

    public static ArrayList<Flowers> sellSequence(int r, int c, int t) {

        flowers.clear();

        int max = max(r, max(c, t));

        for (int i = 0; i < max; i++) {
            if (r > 0) {
                flowers.add(new Rose());
                r--;
                wallet += Rose.getPrice();
            }
            if (c > 0) {
                flowers.add(new Chamomile());
                c--;
                wallet += Chamomile.getPrice();
            }
            if (t > 0) {
                flowers.add(new Tulip());
                t--;
                wallet += Tulip.getPrice();
            }
        }

        return flowers;
    }

}
