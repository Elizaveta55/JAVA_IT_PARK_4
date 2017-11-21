package com.company;

public class Main {

    public static void main(String[] args) {
        TextViewer textViewer = new TextViewer();
        textViewer.setText("Have I done it? 404");

        textViewer.addTask(new findAllLitters());
        textViewer.addTask(new findAllNumeral());
        textViewer.addTask(new findAllPunctuationMarks());

        textViewer.textProcess();
    }
}