package com.company;

import java.time.LocalTime;

public class TVChannel {
    private final int countOfChannels = 10;
    private String nameChannel;
    private TVProgram tvProgram[];
    private LocalTime beginTime;
    private LocalTime endTime;
    LocalTime currentTime = LocalTime.now();

    public TVChannel(String nameChannel){
        this.nameChannel = nameChannel;
    }

    public String getnameChannel(){
        return nameChannel;
    }

    public String getNameProgram(TVProgram tvProgram[]){
        for (int i=0;i<4;i++) {
            if ((currentTime.isAfter(tvProgram[i].getBeginTime()) && currentTime.isBefore(tvProgram[i].getEndTime()))) {
                return tvProgram[i].getName();
            }
        }
        return "Mistake";
    }

    public void broadcastTVProgram(TVProgram tvProgram[], TV tv){
        tv.broadcastTVChannel(tvProgram, this);
    }
}
