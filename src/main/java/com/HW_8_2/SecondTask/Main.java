package com.HW_8_2.SecondTask;


import java.util.Scanner;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // optimal number of threads(individually for each system, cores number + 1)
        int threadsNumber = Runtime.getRuntime().availableProcessors() + 1;

        System.out.print("Size of the myArray: ");

        MyArray array = new MyArray(scanner.nextInt());

        System.out.print("Number of repeats: ");
        int repeats = scanner.nextInt();

        System.out.println("ThreadPool: \n");
        long startThreadPool = System.nanoTime(); // timer

        ExecutorService executor = Executors.newFixedThreadPool(threadsNumber);
        Future future = executor.submit((Callable<?>) new MyThreadPool(array));

        for (int i = 0; i < repeats; i++) {

            try {
                System.out.print("Iteration : " + (i + 1) + "; result = " + future.get() + "; time spent: ");
                System.out.println((double) (System.nanoTime() - startThreadPool) / 1000000000 + " seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

//---------------------------------------------------------------

        System.out.println("\n Thread: \n");

        MyThread myThread = null; // custom object

        for (int i = 0; i < repeats; i++) {
            long startThread = System.nanoTime(); // timer

            for (int j = 0; j < threadsNumber; j++) {

                myThread = new MyThread(array);
                myThread.start();
            }
            try {
                // such sleep time is because there is not enough memory and with 15s sleep the output is correct for 80 millions of elements
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("Iteration : " + (i + 1) + "; result = " + myThread.getResult() + "; time spent: ");
            System.out.println((double) (System.nanoTime() - startThread) / 1000000000 + " seconds");

            startThread = 0;
        }
    }
}
