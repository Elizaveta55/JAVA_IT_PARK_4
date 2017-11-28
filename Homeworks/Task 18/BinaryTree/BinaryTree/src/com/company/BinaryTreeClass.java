package com.company;

public class BinaryTreeClass {
    private Node mainRoot;
    private int count;

    public BinaryTreeClass(){
        this.mainRoot = null;
        this.count = 0;
    }

    public Node getMainRoot() {
        return mainRoot;
    }

    public void add(int value){
        if (count == 0){
            mainRoot = new Node(value);
            mainRoot.left = null;
            mainRoot.right = null;
            count++;
        }
        else {
            Node current = mainRoot;
            while (true){
                if (value > current.value && current.right != null){
                    current = current.right;
                } else {
                    if (value > current.value && current.right == null) {
                        Node NewNode = new Node(value);
                        current.right = NewNode;
                        count++;
                        break;
                    }
                }
                if (value < current.value && current.left != null){
                    current = current.left;
                } else {
                    if (value < current.value && current.left == null) {
                        Node NewNode = new Node(value);
                        current.left = NewNode;
                        count++;
                        break;
                    }
                }
            }
        }
    }

    public void prefix(Node current) {
        if (current != null) {
            System.out.print(current.value + " ");
            prefix(current.left);
            prefix(current.right);
        } else {
            return;
        }
    }

    public void infix(Node current){
        if (current == null){
            return;
        }
        infix(current.left);
        System.out.print(current.value + " ");
        infix(current.right);
    }

    public void postfix(Node current){
        if (current == null){
            return;
        }
        postfix(current.left);
        postfix(current.right);
        System.out.print(current.value + " ");
    }


    private class Node{
        int value;
        Node left;
        Node right;

        Node (int value){
            this.value = value;
        }
    }
}
