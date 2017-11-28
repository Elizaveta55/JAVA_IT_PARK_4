package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeClass binaryTreeClass = new BinaryTreeClass();
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++){
            int element = scanner.nextInt();
            binaryTreeClass.add(element);
        }

        binaryTreeClass.prefix(binaryTreeClass.getMainRoot());
        System.out.println();
        binaryTreeClass.infix(binaryTreeClass.getMainRoot());
        System.out.println();
        binaryTreeClass.postfix(binaryTreeClass.getMainRoot());
    }
}
