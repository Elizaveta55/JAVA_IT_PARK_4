package com.company;

public class ArrayList {
     private final int InitialSize=100;
     private int elements[];
     private int count;

    void setElements(int elements,int count){
        this.elements[count] = elements;
    }

    void setCount(int count){
        if (count<100){
            this.count = count;
        } else {
            System.err.println("No free");
        }
    }

    public ArrayList() {
        elements = new int[InitialSize];
        count = 0;
    }

    public void add(int element) {
        if (count < elements.length) {
            elements[count] = element;
            count++;
        } else {
            System.err.println("No free");
        }
    }

     public void addToBegin(int element){
         for (int i = count - 1; i >= 0; i--) {
             elements[i + 1] = elements[i];
         }
         elements[0] = element;
         count++;
         }

    int getCount(){
     return count;
     }

    int getElements(int index){
      return elements[index];
    }

    public int get(int index) {
       return elements[index];
    }

    public void replace(int index, int element) {
         int temp;
         for (int i = count;i > index;i --){
             temp = elements[i+1];
             elements[i] = elements[i-1];
         }
       elements[index] = element;
        count++;
     }

    public void replace2(int index, int element) {
        elements[index] = element;
    }

    public void sort(){
        for (int i = 0;i < count-1 ; i++){
            for (int j = i+1; j < count; j++){
                if (elements[j] > elements[i]){
                    int temp = elements[j];
                    elements[j] = elements[i];
                    elements[i] = temp;
                }
            }
        }
    }

    public void reverse(){
        int temp;
        for (int i=0; i < count / 2; i++){
            temp = elements[i];
            elements[i] = elements[count-i-1];
            elements[count-i-1] = temp;
        }

    }

    public void remove(int index) {
        for (int i = index; i < count; i++) {
            elements[i] = elements[i + 1];
        }
        count--;
    }

    public int find(int element) {
            int i=0;
            while (elements[i] != element && i <= count){
                i++;
            }
            if (elements[i] == element){
                return i;
            } else {
                return -1;
            }
    }
}
