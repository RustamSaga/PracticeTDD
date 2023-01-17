package com.rustamsaga.practicetdd;

import java.sql.Array;

public class FIFO<T> implements MyStack<T>{

    private final T[] array;
    private int position = -1;

    public FIFO (int maxCount){

        if (maxCount <= 0){
            throw new IllegalStateException("maxCount must be more than zero");
        }
        this.array = (T[]) new Object[maxCount];

    }


    @Override
    public T pop() {
        if (position < 0){
            throw new IllegalStateException("empty stack");
        }
        T item = array[position];
        array[position] = null;
        position--;
        return item;
    }

    @Override
    public void push(T item) {
        position++;
        try{
            array[position] = item;
        }catch (Exception e){
            throw new IllegalStateException("Stack overflow exception, maximum is " + array.length);
        }

    }
}
