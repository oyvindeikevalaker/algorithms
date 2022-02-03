package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {

    private final int bubbleLimit;

    public MixedSort(int bubbleLimit) {
        this.bubbleLimit = bubbleLimit;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {

        if (array == null) return;

        T[] buffer = (T[]) new Comparable[array.length];

        mergeSort(0, array.length - 1, array, buffer);
    }

    private <T extends Comparable<T>> void mergeSort(int low, int high, T[] array, T[] buffer) {
        if (high - low < bubbleLimit) {
            bubbleSort(low, high, array);
            return;
        }

        if (low < high) {
            int middle = low + (high - low) / 2;

            mergeSort(low, middle, array, buffer);
            mergeSort(middle + 1, high, array, buffer);
            merge(low, middle, high, array, buffer);
        }

    }

    private <T extends Comparable<T>> void merge(int low, int middle, int high, T[] array, T[] buffer) {

        for (int i = low; i <= high; i++) {
            buffer[i] = array[i];
        }

        int i = low, j = middle + 1, k = low;

        while (i <= middle && j <= high) {
            if (buffer[i].compareTo(buffer[j]) <= 0) {
                array[k] = buffer[i];
                i++;
            } else {
                array[k] = buffer[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = buffer[i];
            i++;
            k++;
        }
        while (j <= high) {
            array[k] = buffer[j];
            j++;
            k++;
        }

    }

    private <T extends Comparable<T>> void bubbleSort(int low, int high, T[] array) {


        boolean swapped = true;
        int lastSwap = high;

        while (swapped) {

            swapped = false;
            int limit = lastSwap;

            for (int i = low; i < limit; i++) {
                int j = i + 1;


                if (array[i].compareTo(array[j]) > 0) {
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    swapped = true;
                    lastSwap = i;
                }
            }
        }
    }


}









