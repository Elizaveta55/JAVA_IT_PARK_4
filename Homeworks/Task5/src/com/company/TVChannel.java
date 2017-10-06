package com.company;

import java.time.LocalTime;

public class TVChannel {
    private final int countOfChannels = 10;
    private String nameChannel;
    private TVProgram tvProgram[];
    private LocalTime beginTime;
    private LocalTime endTime;

    public TVChannel(String nameChannel){
        this.nameChannel = nameChannel;
        tvProgram = new TVProgram[countOfChannels];
    }

    public String getnameChannel(){
        return nameChannel;
    }

    public void broadcastTVProgram(TV tv){
        //LocalTime currentTime = LocalTime.now();
        tv.broadcastTVChannel(this);
    }
}
