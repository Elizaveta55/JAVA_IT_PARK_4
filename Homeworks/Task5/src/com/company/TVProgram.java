package com.company;

import java.time.LocalTime;

public class TVProgram {
    private String name;
    private LocalTime beginTime;
    private LocalTime endTime;

    public TVProgram(String name,LocalTime beginTime,
                     LocalTime endTime){
        this.name=name;
        this.beginTime=beginTime;
        this.endTime=endTime;
    }

    public String getName(){
        return name;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void toChannel(TVChannel tvChannel, TV tv){
        tvChannel.broadcastTVProgram(this, tv);
    }
}
