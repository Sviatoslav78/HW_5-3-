package com.HW_8_1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class Main {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Total number of people: ");
        int peopleCount = scanner.nextInt();

        System.out.print("Number of people in library at the same time: ");
        int maxAmount = scanner.nextInt();

        Semaphore semaphore = new Semaphore(maxAmount);

        for (int i = 0; i < peopleCount; i++) {
            new Human(semaphore,maxAmount).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
