package com.company;

public class ProgramForParse {
    private char number[];

    public ProgramForParse(char[] number) {
        this.number = number;
    }

    public char[] getNumber() {
        return number;
    }

    int parse() {
        int s = 0;
        for (int i = 0; i < number.length; i++) {
            s = s * 10 + ((int) number[i] - 48);
        }
        return s;
    }
}
