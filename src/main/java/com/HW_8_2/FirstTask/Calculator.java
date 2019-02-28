package com.HW_8_2.FirstTask;

import java.util.concurrent.Callable;

public class Calculator implements Callable {

    double firstNumber;
    double secondNumber;
    String operation;

    public Calculator(double firstNumber, double secondNumber, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    @Override
    public Object call() throws Exception {

        switch (operation) {
            case "1":
                operation = String.valueOf(firstNumber + secondNumber);
                break;

            case "2":
                operation = String.valueOf(firstNumber - secondNumber);
                break;

            case "3":
                operation = String.valueOf(firstNumber * secondNumber);
                break;

            case "4":
                operation = String.valueOf(firstNumber / secondNumber);
                break;

            case "5":
                operation = String.valueOf(firstNumber % secondNumber);
                break;

            case "6":
                if (firstNumber == secondNumber) {
                    operation = "true";
                } else {
                    operation = "false";
                }
                break;

            case "7":
                if (firstNumber > secondNumber) {
                    operation = "true";
                } else {
                    operation = "false";
                }
                break;

            case "8":
                if (firstNumber < secondNumber) {
                    operation = "true";
                } else {
                    operation = "false";
                }
                break;

            default:
                operation = "You've entered invalid operation";
                break;
        }

        return operation;
    }
}
