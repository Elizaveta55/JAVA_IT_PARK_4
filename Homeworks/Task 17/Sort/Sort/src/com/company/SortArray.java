package com.company;

import static com.company.Main.array;
import static com.company.Main.count;

public class SortArray {
    private int helpArray[];
    private int lower, middle, higher;
    private int current = 0;

    public SortArray(int lower, int middle, int higher) {
        helpArray = new int[count];
        for (int i =0;i<count;i++){
            helpArray[i] = array[i];
        }
        this.higher = higher;
        this.middle = middle;
        this.lower = lower;
    }


    public void Sort(int start, int end) {
        if (end <= start) {
            return;
        }
        int middleTemp = start + (end - start) / 2;

        Sort(start, middleTemp);

        Sort(middleTemp+1, end);
        Merge(start, middleTemp, end);
    }

    public void Merge(int lower, int middle, int higher) {
        current = lower;
        int i = lower;
        int j = middle;
        while (i<middle && j<higher){
            if (helpArray[i]<helpArray[j]){
                array[current] = helpArray[i];
                i++;
                current++;
            } else {
                if (helpArray[i]>=helpArray[j]){
                    array[current] = helpArray[j];
                    j++;
                    current++;
                }
            }
        }

        while (i < middle){
            array[current] = helpArray[i];
            i++;
            current++;
        }

        while (j < higher){
            array[current] = helpArray[j];
            j++;
            current++;
        }
    }
}