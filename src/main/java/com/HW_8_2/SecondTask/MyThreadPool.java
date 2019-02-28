package com.HW_8_2.SecondTask;

import java.util.concurrent.Callable;

public class MyThreadPool implements Callable {

    private MyArray myArray;
    private double result;

    public MyThreadPool(MyArray myArray) {
        this.myArray = myArray;
    }

    @Override
    public Object call() {

        for (int i = 0; i < myArray.getSize(); i++) {
            result += Math.sin(myArray.getArray()[i]) + Math.cos(myArray.getArray()[i]);
        }
        return result;
    }
}
