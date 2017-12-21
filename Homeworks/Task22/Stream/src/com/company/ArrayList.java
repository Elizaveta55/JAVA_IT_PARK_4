package com.company;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ArrayList<T> implements com.company.List<T>{
    private Object array[] = new Object[10];
    private int count=0;
    private int iCount=-1;
    Predicate<Object> even = element -> ((int)element/2) == 0;
    Function<Object, Double> findDouble = element -> (Double)0.01;
    Consumer<Object> print = element -> System.out.println(element);

    public Object[] getArray() {
        return array;
    }

    public ArrayList(){
    }

    @Override
    public void add(Object element){
        array[count] = element;
        count++;
    }

    public void doForEach(){
        forEach(print);
    }

    private void forEach(Consumer consumer){
        for(int i=0; i < count; i++) {
            consumer.accept(array[i]);
        }
    }

    public Stream goFilter(){
        return filter(even);
    }

    private Stream filter(Predicate predicate){
        List<Integer> temp= new java.util.ArrayList<>();
        for(int i=0; i < array.length && array[i]!=null; i++){
            if (predicate.test(array[i])==true){
                temp.add((int)array[i]);
            }
        }
        Stream<Integer> tempStream = temp.stream();
        return tempStream;
    }

    public Stream goMap(){
        return map(findDouble);
    }

    private Stream map(Function<Object, Double> function){
        List<Double> temp= new java.util.ArrayList<>();
        for(int i=0; i < array.length; i++){
            temp.add(function.apply(array[i]));
        }
        Stream<Double> tempStream = temp.stream();
        return tempStream;
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
