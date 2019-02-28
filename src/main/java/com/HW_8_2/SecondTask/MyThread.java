package com.HW_8_2.SecondTask;

public class MyThread extends Thread {

    private MyArray myArray;
    private double result = 0;

    public MyThread(MyArray myArray) {
        this.myArray = myArray;
    }

    @Override
    public void run() {

        for (int i = 0; i < myArray.getSize(); i++) {
            result += Math.sin(myArray.getArray()[i]) + Math.cos(myArray.getArray()[i]);
        }
    }

    public double getResult() {
        return result;
    }
}
