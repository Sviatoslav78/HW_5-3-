package com.HW_6;

import java.util.Arrays;

public class MyStack {

    int[] array = new int[0];
    int size = 0;
    int[] temp = new int[0];
    int a;

    public void add(int value) {
        array = Arrays.copyOf(array, size + 1);
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        temp = Arrays.copyOf(temp, array.length - 1);
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];

        }

        for (int i = index + 1; i < array.length; i++) {
            temp[i - 1] = array[index + 1];
        }

        array = Arrays.copyOf(temp, array.length - 1);
        size--;
    }

    public void clear() {
        array = Arrays.copyOf(array,0);
    }

    public int size() {
        return size;
    }

    public int peek() {
        return array[array.length - 1];
    }

    public int poll() {
        a = array[array.length - 1];
        array = Arrays.copyOfRange(array,0,array.length - 2);
        size--;
        return a;
    }
}
