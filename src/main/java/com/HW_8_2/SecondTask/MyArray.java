package com.HW_8_2.SecondTask;

public class MyArray {

    private int size;
    private int[] array;

    public MyArray(int size) {
        this.size = size;
        this.array = new int[size];
        create();
    }

    public int getSize() {
        return size;
    }

    public int[] getArray() {
        return array;
    }


    public void create() {

        array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

    }
}
