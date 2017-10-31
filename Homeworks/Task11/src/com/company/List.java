package com.company;

public interface List<T> extends Iterable<T>{
    public void add(T object);
    public void addToBegin(T object);
}
