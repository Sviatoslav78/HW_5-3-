package com.HW_6;

import java.util.Arrays;

public class MyArrayList {

    public static int numberOfElements = 0;
    public static Object[] array = new Object[10];



    public static void add(String newElement) {

        numberOfElements++;
        if (numberOfElements == 9) {
            array = Arrays.copyOf(array, (int) (array.length*1.5 + 1));
        }

        array[numberOfElements - 1] = newElement;
    }

    public static void remove(int index) {

        numberOfElements--;
        if (array[index] != null) {
        array[index] = null;
        }
    }

    public static void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        array = Arrays.copyOf(array, 10);
        numberOfElements = 0;
    }

    public static int size() {
        return numberOfElements;
    }

    public static Object get(int index) {
        return array[index];
    }



}
