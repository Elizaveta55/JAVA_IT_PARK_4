package com.company;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Настройка телевизора");
        //for (int i = 0; i < 3; i++) {
            System.out.println("Введи название канала");
            String nameOfChannel = scanner.next();

            System.out.println("Введи название передачи для этого канала");
            String name = scanner.next();
            TVProgram tvProgram= new TVProgram(name, LocalTime.parse("00:00"), LocalTime.parse("23:59"));
            //System.out.println("Введи название передачи для этого канала");
            //String name1 = scanner.next();
            //TVProgram tvProgram2 = new TVProgram(name1, LocalTime.parse("06:00"), LocalTime.parse("11:59"));
            //System.out.println("Введи название передачи для этого канала");
            //String name2 = scanner.next();
            //TVProgram tvProgram3 = new TVProgram(name2, LocalTime.parse("12:00"), LocalTime.parse("17:59"));
            //System.out.println("Введи название передачи для этого канала");
            //String name3 = scanner.next();
            //TVProgram tvProgram4 = new TVProgram(name3, LocalTime.parse("18:00"), LocalTime.parse("23:59"));

            TVChannel tvChannel = new TVChannel(nameOfChannel);
        //}
        TV tv = new TV();
        tvProgram.toChannel(tvChannel, tv);
    }

}
