package com.company;

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int count;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if (tail == null){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        count++;
    }

    @Override
    public void addToBegin(Object object) {
        Node newF = new Node(object);
        if (head == null) {
            tail = newF;
        }
        newF.next = head;
        head = newF;
        count++;
    }

    @Override
    public Object get(int index) {
        if (index < 0 && index >= count){
            throw new IllegalArgumentException();
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    @Override
    public void remove(Object object) {
        boolean flag = false;
        Node currentNode = head;
        for (int i = 0 ; i < count; i++){
            if (currentNode.next.value == object) {
                flag = true;
                currentNode.next = currentNode.next.next;
                count--;
            }
            currentNode = currentNode.next;
        }
        if (flag == false){
            System.err.println("Нет такого элемента");
        }
    }

    @Override
    public int IndexOf(Object object) {
        boolean flag = false;
        int index = 0;
        Node currentNode = head;
        for (int i = 0 ; i < count; i++){
            if (currentNode.next.value == object) {
                flag = true;
                index = i;
            }
            currentNode = currentNode.next;
        }
        if (flag == false){
            System.err.println("Нет такого элемента");
            return -1;
        }
        return index;
    }

    @Override
    public int sizeOf() {
        return count;
    }

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
        }

        @Override
        public boolean HasNext() {
            return currentNode != null;
        }
    }

    private static class Node {
        Object value;
        Node next;

        Node(Object object){
            this.value = object;
        }
    }
}
