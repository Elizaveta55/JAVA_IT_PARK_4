package com.company;

import java.util.Scanner;

public class Main {
    public static int count[];
    public static int i=0;

    public static void main(String[] args) {
        count = new int [124];
        for (int i=0;i<124; i++)
            count[i]=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        String string = scanner.nextLine();
        Parser parser = new Parser();
        parser.addMethodd(new CountDigit());
        parser.addMethodd(new CountLetter());
        parser.addMethodd(new CountSpace());
//        Parser parser = Parser.builder();
//                      .methodd1(new CountDigit());
//                      .methodd2(new CountLetter());
//                      .methodd3(new CountSpace());
        parser.beforeEvent(string, count);
    }
}
