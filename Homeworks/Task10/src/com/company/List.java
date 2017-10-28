package com.company;

public interface List extends Iterable {
    void add(Object element);

    void addToBegin(Object object);

    Object get(int index);

    void remove(Object object);

    int IndexOf(Object object);

    int sizeOf();
}
