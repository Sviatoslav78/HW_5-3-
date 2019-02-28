package com.HW_8_1;

public class Door extends Thread {

    public void run() {

        System.out.println(Thread.currentThread().getName() + " проходит через дверь внутрь");

        try {
            sleep(500);
            System.out.println(Thread.currentThread().getName() + " прошел через дверь внутрь");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
