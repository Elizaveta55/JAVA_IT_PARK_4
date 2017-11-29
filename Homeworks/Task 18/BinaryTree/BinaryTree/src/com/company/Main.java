package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeClass binaryTreeClass = new BinaryTreeClass();
        System.out.println("Введи элемент массива");
        int element = scanner.nextInt();
        binaryTreeClass.BeginAdd(element);


        binaryTreeClass.BeginPrefix();
        System.out.println();
        binaryTreeClass.BeginInfix();
        System.out.println();
        binaryTreeClass.BeginPostfix();
    }
}
