package com.company;

import java.util.Scanner;

public class BinaryTreeClass {
    private Node mainRoot;
    private int count;
    Scanner scanner = new Scanner(System.in);

    public BinaryTreeClass(){
        this.mainRoot = null;
        this.count = 0;
    }

    public void BeginPrefix(){
        prefix(mainRoot);
    }

    public void BeginInfix(){
        infix(mainRoot);
    }

    public void BeginPostfix(){
        postfix(mainRoot);
    }

    public void BeginAdd(int value){
        if (mainRoot == null) {
            mainRoot = new Node(value);
            System.out.println("Введи элемент массива");
            value = scanner.nextInt();
        }
            while (value!=0){
                add(mainRoot, value);
                System.out.println("Введи элемент массива");
                value = scanner.nextInt();
            }
    }

    public void add(Node current, int value) {
        if (value > current.value) {
            if (current.right == null){
                current.right = new Node(value);
            }else {
                add(current.right, value);
            }
        }
        if (value < current.value) {
            if (current.left == null) {
                current.left = new Node(value);
            }
            else{
                add(current.left, value);
            }
        }
    }


    private void prefix(Node current) {
        if (current == null){
            return;
        }
        System.out.print(current.value + " ");
        prefix(current.left);
        prefix(current.right);
    }

    private void infix(Node current){
        if (current == null){
            return;
        }
        infix(current.left);
        System.out.print(current.value + " ");
        infix(current.right);
    }

    private void postfix(Node current){
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
