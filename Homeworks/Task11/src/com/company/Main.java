package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    private static final int Size_of_ArreyBytes = 40000;
    private static final int Size_of_Name = 30;
    private static final int Size_of_Age = 2;
    private static final int Size_of_Array_or_List = 100;

    public static void main(String[] args) {
        try {
            FileInputStream input= new FileInputStream("input.txt");
            PrinterOfIterable printerOfIterable = new PrinterOfIterable();
            byte bytes[] = new byte[Size_of_ArreyBytes];
            byte name[] = new byte[Size_of_Name];
            byte age[] = new byte[Size_of_Age];
            int CountAge[] = new int [Size_of_Array_or_List];
            int count = input.read(bytes);
            String text = null;
            bytes[count] = (byte)'\n'; bytes[count+1] = (byte)'\r';
            ArrayList arrayList[] = new ArrayList[Size_of_Array_or_List];
            LinkedList linkedList[] = new LinkedList[Size_of_Array_or_List];

            for (int i = 0;i < Size_of_Array_or_List; i ++){
                arrayList[i] = new ArrayList();
                linkedList[i] = new LinkedList();
            }

            int mark=0;
            int k=0;
            for (int i = 0; i < count+1; i++) {
                if (bytes[i] == ' ') {
                    int k1 = k;
                    k = 0;
                    for (int j = mark; j < i; j++) {
                        name[k] = bytes[j];
                        mark++;
                        k++;
                    }
                    text = new String(name);
                    for (int j = 0; j < k; j++) {
                        name[j] = 0;
                    }
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
                    int ageInt = Integer.parseInt(Age);
                    CountAge[ageInt]++;
//                    System.out.println(text + " " + ageInt);
                    linkedList[ageInt].add(text);
                    arrayList[ageInt].add(linkedList);
                }
            }
            for (int i = 0; i < Size_of_Array_or_List; i++) {
                if (CountAge[i] != 0) {
                    System.out.println("Людей возраста " + i + " нашлось " + CountAge[i] + " штук");

                    Iterator iteratorLink = linkedList[i].iterator();
                    printerOfIterable.print(iteratorLink);
//                    Iterator iteratorArray = arrayList[i].iterator();
//                    printerOfIterable.print(iteratorArray);
                }
            }
        } catch (java.io.IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
