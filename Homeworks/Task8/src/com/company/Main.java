package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        //String str="sdg 86 hf";
        //char ar[]= str.toCharArray();
        //for (int k=0;k<ar.length;k++)
        //    System.out.println(ar[k] + " ");
        String string = scanner.next();
        Parser parser = new Parser();
        parser.addMethodd(new CountDigit());
        parser.addMethodd(new CountLetter());
        parser.addMethodd(new CountShift());
        parser.beforeEvent(string);
    }
}
