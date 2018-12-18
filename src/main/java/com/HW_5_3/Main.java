package com.HW_5_3;


import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) {


        FlowerStore flowerStore = new FlowerStore();

        flowerStore.sell(1,2,3);
        flowerStore.showFlowers();

        System.out.println();

        flowerStore.sellSequence(1,2,3);
        flowerStore.showFlowers();

        System.out.println();

        System.out.println("Wallet: " + FlowerStore.getWallet() + "$");

        try {
            FlowersLoader.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

