package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Program program;
        ProgramForParse programForParse;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Меню.");
            System.out.println("Выдерите:");
            System.out.println("1. Проверка символа");
            System.out.println("2. Работа с массивом символов");
            System.out.println("3. Закончить работу");
            int command = scanner.nextInt();
            if (command == 3) break;
            switch (command) {
                case 1:
                    while (true) {
                        System.out.println("Введи символ");
                        String cc = scanner.next();
                        char[] c = cc.toCharArray();
                        program = new Program(c[0]);
                        System.out.println("Проверить символ на:");
                        System.out.println("1. Является ли буквой");
                        System.out.println("2. Является ли цифрой");
                        System.out.println("3. Является ли заглавной буквой");
                        System.out.println("4. Является ли строчной буквой");
                        System.out.println("5. Закончить работу с символом");
                        int command2 = scanner.nextInt();
                        switch (command2) {
                            case 1:
                                if (program.isLetter() == true) System.out.println("Верно");
                                else System.out.println("Не верно1");
                                break;
                            case 2:
                                if (program.isDigit() == true) System.out.println("Верно");
                                else System.out.println("Не верно2");
                                break;
                            case 3:
                                if (program.isUpper() == true) System.out.println("Верно");
                                else System.out.println("Не верно3");
                                break;
                            case 4:
                                if (program.isLower() == true) System.out.println("Верно");
                                else System.out.println("Не верно4");
                                break;
                            case 5:
                                break;
                        }
                        if (command2 == 5) break;
                    }
                    break;
                case 2:
                    System.out.println("Введи символы");
                    String cc = scanner.next();
                    char[] c = cc.toCharArray();
                    programForParse = new ProgramForParse(c);
                    System.out.println(programForParse.parse());
                    break;
            }
        }

    }
}
