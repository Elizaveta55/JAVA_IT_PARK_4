package com.company;

public class ArrayList<T> implements List<T>{
    private Object array[];
    private int count;
    private int iCount=-1;

    public ArrayList(){
        this.array = new Object[100];
        this.count = 0;
    }

    @Override
    public void add(T object) {
        array[count] = object;
        count++;
    }

    @Override
    public void addToBegin(T object) {
        for (int i = count - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = object;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator<E> implements Iterator<E>{

        @Override
        public Object next() {
            Object value = array[iCount];
            iCount++;
            return value;
        }

        @Override
        public boolean HasNext() {
            return iCount+1 != count;
        }
    }
}
