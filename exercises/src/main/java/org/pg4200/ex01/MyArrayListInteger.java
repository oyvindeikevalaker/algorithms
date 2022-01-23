package org.pg4200.ex01;

public class MyArrayListInteger implements MyListInt{

    private Integer[] data;

    private int size = 0;

    public MyArrayListInteger() {
        this(10);
    }

    public MyArrayListInteger(int maxSize) {data = new Integer[maxSize];}


    @Override
    public Integer get(int index) {
        if(index<0||index>size){
            return null;
        }

        return data[index];
    }

    @Override
    public void add(Integer value) {
        data[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
