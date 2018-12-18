package com.HW_5_3;

public class Tulip extends Flowers {

    private static int price = 45;

    public Tulip() {
        name = "tulip";
    }

    public static int getPrice() {
        return price;
    }
}
