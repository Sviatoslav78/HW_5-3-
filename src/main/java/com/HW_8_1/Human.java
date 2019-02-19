package com.HW_8_1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Human extends Thread {

    CyclicBarrier barrier = new CyclicBarrier(1, new Door());
    private Semaphore semaphore;

    private int maxPeople;
    private int numberOfPeople = 1;
    int readingTime;


    public Human(Semaphore semaphore, int maxPeople) {
        this.semaphore = semaphore;
        this.maxPeople = maxPeople;
    }

    public void run() {

        System.out.println(Thread.currentThread().getName() + " пришел ко входу в библиотеку");
        System.out.println(Thread.currentThread().getName() + " подошёл к двери с улицы");

        try {
            semaphore.acquire(); // semaphore request
            barrier.await(); // activating barrier

            System.out.println(Thread.currentThread().getName() + " вошел в библиотеку");


            while (numberOfPeople <= maxPeople) {

                System.out.println(Thread.currentThread().getName() + " читает книгу");
                readingTime = (int) (Math.random()*4000 + 1000); // calculating random reading time
                sleep(readingTime);

                numberOfPeople++;
                semaphore.release(); // make semaphore free
                System.out.println(Thread.currentThread().getName() + " проходит через дверь наружу");
                sleep(500);

                System.out.println(Thread.currentThread().getName() + " прошел через дверь наружу");
                System.out.println(Thread.currentThread().getName() + " вышел из библиотеки");
            }

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getStackTrace());
        } catch (BrokenBarrierException e) {
            System.out.println(Thread.currentThread().getStackTrace());
        }

    }

}
