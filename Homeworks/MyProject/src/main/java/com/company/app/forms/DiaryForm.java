package com.company.app.forms;

import lombok.Data;

import java.time.LocalTime;

@Data
public class DiaryForm {
    private String timeGoToSleep;
    private String timeWakeUpCurrent;
    private int testGoodSleep;
    private int testMoonWalker;
    private int testDreams;
}
