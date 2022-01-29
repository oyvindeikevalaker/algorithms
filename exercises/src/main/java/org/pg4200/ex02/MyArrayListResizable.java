package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizable<T> extends MyArrayList<T> {

    public MyArrayListResizable(int capacity){
        super(capacity);
    }

    @Override
    public void add(int index, T value) {

        if (size == data.length) {
            data = doubleArraySize(data);
        }

        super.add(index, value);

    }

    private static Object[] doubleArraySize(Object[] old) {
        Object[] tmp = new Object[old.length * 2];
        System.arraycopy(old, 0, tmp, 0, old.length);
        old = tmp;

        /**
         * Alternative code from solution - using for loop instead of arraycopy:
         * Object[] bigger = new Object[data.length * 2];
         *   for(int i=0; i<data.length; i++){
         *       bigger[i] = data[i];
         *   }
         *   data = bigger;
         * **/

        return old;
    }


}
