package com.company;

public class ArrayList  implements List{
    private Object array[];
    private int count;
    private int iCount=-1;

    public ArrayList(){
        this.array = new Object[100];
        this.count = 0;
    }

    @Override
    public void add(Object object) {
        array[count] = object;
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
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator{

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
