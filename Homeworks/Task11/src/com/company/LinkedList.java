package com.company;

public class LinkedList implements List{
    private Node head;
    private Node tail;
    private int count;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        count = 0;
    }

    @Override
    public void add(Object object) {
        Node newNode = new Node(object);
        if (tail == null ){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    @Override
    public void addToBegin(Object object){
        Node newNode = new Node(object);
        if (head == null) {
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        count++;
    };

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator{
        private Node currentNode = head;

        @Override
        public Object next(){
            Object element = currentNode.value;
            currentNode = currentNode.next;
            return element;
        };

        @Override
        public boolean HasNext(){
            return currentNode != null;
        };
    }

    private static class Node {
        Object value;
        Node next;

        Node (Object object){
            this.value = object;
        }
    }
}
