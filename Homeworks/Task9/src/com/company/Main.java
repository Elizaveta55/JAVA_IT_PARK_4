package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream input= new FileInputStream("input.txt");
            byte bytes[] = new byte[40000];
            byte word[] = new byte[1000];
            byte age[] = new byte[2];
            int CountAge[] = new int [1000];
            int count = input.read(bytes);
            bytes[count] = (byte)'\n'; bytes[count+1] = (byte)'\r';
            int mark=0;
            int k=0;
            for (int i = 0; i < count+1; i++) {
                if (bytes[i] == ' ') {
                    int k1 = k;
                    k = 0;
                    for (int j = mark; j < i; j++) {
                        word[k] = bytes[j];
                        mark++;
                        k++;
                    }
//                    String text = new String(word);
//                    System.out.println(text);
//                    for (int j = 0; j < k; j++) {
//                        word[j] = 0;
//                    }
                }

                if (bytes[i] == '\n') {
                    int temp = mark + 1;
                    k = 0;
                    mark = i + 1;
                    for (int j = temp; j < i-1; j++){
                        age[k]=bytes[j];
                        k++;
                    }
                    String Age = new String(age);
//                    System.out.println(Age);
//                    char[] charArray = Age.toCharArray();
//                    for (int l = 0; l < charArray.length; l++) {
//                        System.out.println(charArray[l]);
//                    }
//                    int s = 0;
//                    for (int l = 0; l < charArray.length; l++) {
//                            s = s * 10 + ((int) charArray[l] - 48);
//                        }
//                    System.out.println(s);
                    int ageInt = Integer.parseInt(Age);
                    CountAge[ageInt]++;
                }
            }
            for (int i=0;i<100;i++){
                if (CountAge[i] != 0) {
                    System.out.println("Людей возраста " + i + " нашлось " + CountAge[i] + " штук");
                }
            }
        } catch (java.io.IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
