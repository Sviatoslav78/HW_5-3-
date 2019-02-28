package com.HW_8_2.FirstTask;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String operation;

        System.out.print("Enter first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double secondNumber = scanner.nextDouble();

        System.out.println("Choose operation(by number): ");
        System.out.println("1. +\n2. -\n3. *\n4. /\n5. %\n6. ==\n7. >\n8. <");
        scanner.nextLine();
        operation = scanner.nextLine();

        ExecutorService executor = Executors.newSingleThreadExecutor(); // get ExecutorService and create single thread ex.
        Calculator calculator = new Calculator(firstNumber, secondNumber, operation); // creation object of custom class

        Future future = executor.submit(calculator); // submit callable task

        try {
            System.out.println("Your result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}