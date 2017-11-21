package com.company;

public class TextViewer{

    private WorkWithThread runnables[];
    int count=0;
    public static String text;

    public void setText (String text){
        this.text = text;
    }
    public TextViewer(){
        this.runnables = new WorkWithThread[3];
    }

    public void textProcess() {
        for (int i=0;i<3;i++) {
            runnables[i].threadEvent(text);
        }
    }

    public void addTask(WorkWithThread task){
        runnables[count] = task;
        count++;
    }

}
