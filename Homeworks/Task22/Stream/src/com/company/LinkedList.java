package com.company;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LinkedList<T> implements com.company.List{
    private Node<T> head;
    private Node<T> tail;
    private int count;
    Predicate<Node> even= element -> (element.value.equals(6));
    Function<T, Integer> findDouble = element -> (Integer)element;
    Consumer<T> print = element -> System.out.println(element);

    public LinkedList(){
        this.head = null;
        this.tail = null;
        count = 0;
    }

    @Override
    public void add(Object object) {
        Node<T> newNode = new Node(object);
        if (tail == null ){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    public void doForEach(){
        forEach(print);
    }

    private void forEach(Consumer consumer){
        Node<T> currentNode = head;
        for(int i=0; i < count; i++) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public Stream doFilter(){
        return filter(even);
    }

    private Stream filter(Predicate predicate){
        List<T> temp= new java.util.LinkedList<>();
        Node<T> currentNode = head;
        while (currentNode.next!=null){
            if (predicate.test(currentNode)==true){
                temp.add(currentNode.value);
            }
            currentNode = currentNode.next;
        }
        Stream<T> tempStream = temp.stream();
        return tempStream;
    }

    public Stream doMap(){
        return map(findDouble);
    }

    private Stream map(Function<T, Integer> function){
        List<Integer> temp= new java.util.LinkedList<Integer>();
        Node<T> currentNode = head;
        while (currentNode.next!=null){
            temp.add(function.apply(currentNode.value));
            currentNode = currentNode.next;
        }
        Stream<Integer> tempStream = temp.stream();
        return tempStream;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
        private Node<T> currentNode = head;

        @Override
        public T next(){
            T element = currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean HasNext(){
            return currentNode != null;
        }
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node (E object){
            this.value = object;
        }
    }
}