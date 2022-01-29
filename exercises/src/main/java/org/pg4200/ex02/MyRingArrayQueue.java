package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;

    int head = -1;
    int tail = -1;

    public MyRingArrayQueue() {
        this(10);
    }

    public MyRingArrayQueue(int capacity) {
        data = new Object[capacity];
    }

    @Override
    public void enqueue(Object value) {
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else if (head <= tail) {

            if (tail < data.length - 1) {
                //there is space
                tail++;
            } else {

                if (head != 0) {
                    // 0 is free, set tail to free
                    tail = 0;
                } else {
                    // 0 is not free and no space in "end" of array, double size of array
                    Object[] tmp = new Object[data.length * 2];

                    int size = size();
                    System.arraycopy(data, 0, tmp, 0, data.length);
                    data = tmp;
                    tail++;
                }
            }
        } else {
            assert tail < head;
            if (tail < head - 1) {
                tail++;
            } else {
                Object[] tmp = new Object[data.length * 2];

                int k = data.length - head;
                if (k >= 0) System.arraycopy(data, head + 0, tmp, 0, k);
                if (tail + 1 >= 0) System.arraycopy(data, 0, tmp, k + 0, tail + 1);
                head = 0;
                tail = data.length;
                data = tmp;
            }
        }

        data[tail] = value;
    }

    @Override
    public T dequeue() {

        if (isEmpty()) {
            throw new RuntimeException();
        }

        T value = (T) data[head];

        if (size() == 1) {
            //now it ll be empty
            head = -1;
            tail = -1;
        } else {
            head++;
            if(head>= data.length){
                head=0;
            }
        }

        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        return (T) data[head];
    }

    @Override
    public int size() {

        if (head < 0) {
            return 0;
        } else if (head == tail) {
            return 1;
        }else if (head<tail){
            return (tail-head) +1;
        }else{
            int size=0;
            size+=(data.length-head);
            size+=tail+1;

            return size;
        }
    }
}
