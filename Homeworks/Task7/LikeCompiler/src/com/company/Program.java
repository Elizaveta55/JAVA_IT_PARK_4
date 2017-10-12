package com.company;

public class Program {
    private char c;

    public Program(char c) {
        this.c = c;
    }

    public char getC() {
        return c;
    }

    boolean isLetter() {
        if (((int) c > 64 && (int) c < 91) || ((int) c > 96 && (int) c < 123)) return true;
        else return false;
    }

    boolean isUpper() {
        if (((int) c > 64 && (int) c < 91)) return true;
        else return false;
    }

    boolean isLower() {
        if (((int) c > 96 && (int) c < 123)) return true;
        else return false;
    }

    boolean isDigit() {
        if (((int) c > 47 && (int) c < 58)) return true;
        else return false;
    }

}
