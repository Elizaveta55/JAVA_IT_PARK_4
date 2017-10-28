package com.company;

public class ArrayList implements List {

    private Object array[];
    private int count;
    private int iCount=-1;

    public ArrayList(){
        this.array = new Object[10];
        this.count = 0;
    }

    @Override
    public void add(Object element) {
        array[count] = element;
        count++;
    }

    @Override
    public void addToBegin(Object object) {
        for (int i = count - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = object;
    }

    @Override
    public Object get(int index) {

        return null;
    }

    @Override
    public void remove(Object object) {
        boolean flag=false;
        for (int i=0;i<count;i++){
            if (array[i] == object){
                for (int j = i; j < count; j++) {
                    array[j] = array[j + 1];
                }
                flag = true;
            }
        }
        if (flag == false){
            System.err.println("Нет такого элемента");
        }
    }

    @Override
    public int IndexOf(Object object) {
        boolean flag=false;
        int index=0;
        for (int i=0;i<count;i++){
            if (array[i] == object){
                index = i;
                flag = true;
            }
        }
        if (flag == false){
            System.err.println("Нет такого элемента");
            return -1;
        }
        return (index);
    }

    @Override
    public int sizeOf() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {

        @Override
        public Object next() {
            iCount++;
            return (array[iCount]);
        }

        @Override
        public boolean HasNext() {
            return iCount+1 != count;
        }
    }
}
