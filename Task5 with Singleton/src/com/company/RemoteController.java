package com.company;

import java.util.Scanner;

public class RemoteController {
    public final int Count_of_Channels=4;
    Scanner scanner = new Scanner(System.in);

    public void Play(TVProgram tvProgram[][], TVChannel tvChannel[], TV tv){
        System.out.println("Выбери канал:");
        System.out.print("с 0 по ");
        System.out.println(Count_of_Channels-1);
        System.out.println("Кнопка 5 для выключения телевизора");
        while(true) {
            int channel = scanner.nextInt();
            if (channel >= 0 && channel < 3) {
                tvProgram[channel][0].toChannel(tvProgram[channel], tvChannel[channel], tv);
            } else if (channel != 5) {
                System.err.println("Нет такого канала");
            } else {
                break;
            }
        }
    }
}
