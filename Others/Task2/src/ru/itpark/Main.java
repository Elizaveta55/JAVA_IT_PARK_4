package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int a[];
        a = new int[100];
        int count = 0;
        System.out.println("Выберите нужное действие:");
        System.out.println("1 - Показать массив");
        System.out.println("2 - Добавить в начало");
        System.out.println("3 - Добавить в конец");
        System.out.println("4 - Удалить по позиции");
        System.out.println("5 - Выход");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int com = scanner.nextInt();
            switch (com) {
                case 1:
                    System.out.println("Всего элементов:" + count);
                    for (int i = 0; i < count; i++)
                        System.out.println(a[i]);
                    break;
                case 2:
                    System.out.println("Введите элемент, который надо добавить в начало");
                    int b = scanner.nextInt();
                    if (count < 100) {
                        for (int i = count - 1; i >= 0; i--) {
                            a[i + 1] = a[i];
                        }
                        a[0] = b;
                        count++;
                    } else {
                        System.out.println("Хранилище переполнено.");
                    }
                    break;
                case 3:
                    System.out.println("Введите элемент, который надо добавить в конец");
                    int с = scanner.nextInt();
                    if (count < 100) {
                        a[count] = с;
                        count++;
                    } else {
                        System.out.println("Хранилище переполнено.");
                    }
                    break;
                case 4:
                    System.out.println("Введите номер элемента, который надо удалить");
                    int pos = scanner.nextInt();
                    if (pos < count) {
                        for (int i = pos; i < count; i++) {
                            a[i] = a[i + 1];
                        }
                        count--;
                    } else {
                        System.out.println("Ячейка пуста");
                    }
                    break;
                case 5:
                    break;
            }
            if (com == 5) break;
        }
    }
}
