package com.HW_7;

public class Fruit {

    private FruitType type;
    private long shelfLife;
    private long date;
    private int price;

    public Fruit(FruitType fruitType, int shelfLife, int date, int price) {
        this.type = fruitType;
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }

    public FruitType getType() {
        return type;
    }

    public long getShelfLife() {
        return shelfLife;
    }

    public long getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

}
