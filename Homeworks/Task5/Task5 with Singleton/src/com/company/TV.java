package com.company;

import java.time.LocalTime;

public class TV {
    private static TV instance;
    private final int countOfChannels = 5;
    private TVChannel tvChannel[];

    private TV (){
        tvChannel = new TVChannel[countOfChannels];
    }

    static{
        instance = new TV();
    }

    public static TV getInstance(){
        return instance;
    }

    public void broadcastTVChannel(TVProgram tvProgram[], TVChannel tvChannel){
        LocalTime currentTime = LocalTime.now();
        System.out.print("Channel - ");
        System.out.println(tvChannel.getnameChannel());
        System.out.print("Program - ");
        System.out.println(tvChannel.getNameProgram(tvProgram));
    }
}
