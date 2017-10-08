package com.company;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int Count_TVChannel = 3;
        final int Count_TVProgram = 4;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Настройка телевизора");
        RemoteController device = new RemoteController();
        TVProgram tvProgram[][];
        TVChannel tvChannel[];
        tvProgram = new TVProgram[Count_TVChannel][Count_TVProgram];
        tvChannel = new TVChannel[Count_TVChannel];
        TV tv = new TV();
        for (int i = 0; i < Count_TVChannel; i++) {
            System.out.println("Введи название канала");
            String nameOfChannel = scanner.next();

            System.out.println("Введи название первой передачи для этого канала");
            String name = scanner.next();
            tvProgram[i][0] = new TVProgram(name, LocalTime.parse("00:00"), LocalTime.parse("05:59"));
            System.out.println("Введи название второй передачи для этого канала");
            String name1 = scanner.next();
            tvProgram[i][1] = new TVProgram(name1, LocalTime.parse("06:00"), LocalTime.parse("11:59"));
            System.out.println("Введи название третьей передачи для этого канала");
            String name2 = scanner.next();
            tvProgram[i][2] = new TVProgram(name2, LocalTime.parse("12:00"), LocalTime.parse("17:59"));
            System.out.println("Введи название четвертой передачи для этого канала");
            String name3 = scanner.next();
            tvProgram[i][3] = new TVProgram(name3, LocalTime.parse("18:00"), LocalTime.parse("23:59"));
            tvChannel[i] = new TVChannel(nameOfChannel);

            tvProgram[i][0].toChannel(tvProgram[i], tvChannel[i], tv);
        }
        System.out.println("Настройка телефизора закончилась");
        device.Play(tvProgram, tvChannel, tv);
    }
}
