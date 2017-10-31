package com.company;

public class LinkedList<T> implements List<T>{
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        count = 0;
    }

    @Override
    public void add(T object) {
        Node<T> newNode = new Node<>(object);
        if (tail == null ){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    @Override
    public void addToBegin(T object){
        Node<T> newNode = new Node<>(object);
        if (head == null) {
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        count++;
    };

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
        };

        @Override
        public boolean HasNext(){
            return currentNode != null;
        };
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node (E object){
            this.value = object;
        }
    }
}