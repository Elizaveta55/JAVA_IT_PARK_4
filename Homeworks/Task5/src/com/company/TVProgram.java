package com.company;

import java.time.LocalTime;

public class TVProgram {
    private string name;
    private LocalTime beginTime;
    private LocalTime endTime;

    public TVProgram(string name,LocalTime beginTime,
                     LocalTime endTime){
        this.name=name;
        this.beginTime=beginTime;
        this.endTime=endTime;
    }

    public string getName(){
        return name;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void toChannel(){
        //доделать!!!
    }
}
