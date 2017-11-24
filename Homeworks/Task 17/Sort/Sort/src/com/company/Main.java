package com.company;

import java.util.Scanner;

public class Main {
    public static int array[];
    public static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи число элементов массива");
        count = scanner.nextInt();
        System.out.println("Введи элементы массива");
        array = new int[count];
        for (int i = 0; i < count; i++){
            array[i] = scanner.nextInt();
        }
        SortArray sortArray = new SortArray(0, count/2, count);
        sortArray.Sort(0, count);
        for (int i = 0; i < count; i++){
            System.out.println(array[i]);
        }
    }
}
