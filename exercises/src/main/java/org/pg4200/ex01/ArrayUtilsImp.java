package org.pg4200.ex01;

import java.util.Arrays;

public class ArrayUtilsImp implements ArrayUtils{

    @java.lang.Override
    public int min(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int min = array[0];
        for(int i=0;i< array.length;i++){
            int val = array[i];
            if (val<min){
                min = val;
            }
        }

        return min;
    }

    private void checkArray(int[] array) {
        if (array == null || array.length == 0) {
            throw  new IllegalArgumentException("Invalid array");
        }
    }

    @java.lang.Override
    public int max(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int max = array[0];
        for(int i=0;i< array.length;i++){
            int val = array[i];
            if (val>max){
                max = val;
            }
        }

        return max;
    }

    @java.lang.Override
    public double mean(int[] array) throws IllegalArgumentException {
        checkArray(array);

        double mean = array[0];
        int sum = 0;

        for(int i=0;i< array.length;i++){
            sum += array[i];
        }

        return sum / array.length;
    }
}
