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
        tvProgram = new TVProgram[countOfChannels];
    }

    public String getnameChannel(){
        return nameChannel;
    }

    public String getNameProgram(){
        return tvProgram[findProgram(currentTime)].getName();
    }

    public int findProgram(LocalTime currentTime){
        int mark=0;
        for (int i=0;i<1;i++){
            if ((currentTime.isAfter(tvProgram[i].getBeginTime()) && currentTime.isBefore(tvProgram[i].getEndTime()))){
                mark=i;
            }
        }
        return mark;
    }

    public void broadcastTVProgram(TVProgram tvProgram, TV tv){
        tv.broadcastTVChannel(this);
    }
}
