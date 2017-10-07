package com.company;

import java.time.LocalTime;

public class TV {
    private final int countOfChannels = 5;
    private TVChannel tvChannel[];

    public TV (){
        tvChannel = new TVChannel[countOfChannels];
    }

    public void broadcastTVChannel(TVChannel tvChannel){
        LocalTime currentTime = LocalTime.now();
        System.out.print("Channel - ");
        System.out.println(tvChannel.getnameChannel());
        System.out.print("Program - ");
        System.out.println(tvChannel.getNameProgram());
    }
}
