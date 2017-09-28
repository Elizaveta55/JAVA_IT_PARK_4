package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

        public static void sort(int b[], int n){
            for (int i=0;i<n-1;i++){
                for (int j=i+1;j<n;j++){
                    if (b[j]>b[i]){
                        int temp=b[j];
                        b[j]=b[i];
                        b[i]=temp;
                    }
                }
            }
        }

        public static void show(int b[], int n){
            System.out.println("Всего элементов:" + n);
            for (int i = 0; i < n; i++)
                System.out.println(b[i]);
        }

        public static void addBegin(int b[], int n, int newAdd){
                for (int i = n - 1; i >= 0; i--) {
                    b[i + 1] = b[i];
                }
                b[0] = newAdd;
        }

        public static void addEnd(int b[], int n, int NewAdd){
            b[n] = NewAdd;
        }

        public static void Delete(int b[], int n, int number){
            for (int i = number; i < n; i++) {
                b[i] = b[i + 1];
            }
        }

        public static void main(String[] args) {

            int a[];
            a = new int[100];
            int count = 0;
            System.out.println("Выберите нужное действие:");
            System.out.println("1 - Показать массив");
            System.out.println("2 - Добавить в начало");
            System.out.println("3 - Добавить в конец");
            System.out.println("4 - Удалить по позиции");
            System.out.println("5 - Отсортировать массив");
            System.out.println("6 - Выход");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                int com = scanner.nextInt();
                switch (com) {
                    case 1:
                        show(a,count);
                        break;
                    case 2:
                        System.out.println("Введите элемент, который надо добавить в начало");
                        int c = scanner.nextInt();
                        if (count < 100) {
                            addBegin(a,count,c);
                            count++;
                        } else {
                            System.out.println("Хранилище переполнено.");
                        }
                        break;
                    case 3:
                        System.out.println("Введите элемент, который надо добавить в конец");
                        int Elem = scanner.nextInt();
                        if (count < 100) {
                            addEnd(a,count, Elem);
                            count++;
                        } else {
                            System.out.println("Хранилище переполнено.");
                        }
                        break;
                    case 4:
                        System.out.println("Введите номер элемента, который надо удалить");
                        int pos = scanner.nextInt();
                        if (pos < count) {
                           Delete(a,count,pos);
                            count--;
                        } else {
                            System.out.println("Ячейка пуста");
                        }
                        break;
                    case 5:
                        sort(a,count);
                        show(a,count);
                    case 6:
                        break;
                }
                if (com == 6) break;
            }
        }
    }
