package com.company;

import java.util.Scanner;
import com.company.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList lists[] = new ArrayList[5];
        boolean mark[] = new boolean[5];
        for (int i = 0;i < 5; i++) {mark[i] = false;}
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Меню:");
            System.out.println("1. Создать 1 из 5 списков");
            System.out.println("2. Показать список.");
            System.out.println("3. Работа с списком");
            System.out.println("4. Закончить работу");
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    System.out.println("Введите номер списка");
                    int number=scanner.nextInt();
                    mark[number] = true;
                    if (number > 5){
                        System.err.println("Неверный вариант");
                    } else {
                        lists[number] = new ArrayList();
                        while(true) {
                            System.out.println("Добавить элемент в:");
                            System.out.println("1. конец");
                            System.out.println("2. начало");
                            System.out.println("3. закончить");
                            int command2 = scanner.nextInt();
                            switch (command2) {
                                case 1:
                                    System.out.println("Введите число, которое нужно добавить в конец списка");
                                    int num = scanner.nextInt();
                                    lists[number].add(num);
                                    break;
                                case 2:
                                    System.out.println("Введите число, которое нужно добавить в начало списка");
                                    num = scanner.nextInt();
                                    lists[number].addToBegin(num);
                                    break;
                                case 3:
                                    break;
                            }
                            if (command2 == 3) break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите номер списка, который хотите посмотреть");
                    int num = scanner.nextInt();
                    if (mark[num] != true){
                        System.err.println("Нет такого списка");
                    } else {
                        for(int i = 0;i < lists[num].getCount(); i++){
                            System.out.println(lists[num].getElements(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите номер списка");
                    num = scanner.nextInt();
                    if (mark[num] == true) {
                        System.out.println("Выберите нужный вариант:");
                        System.out.println("1. Вставить элемент в заданную позицию со сдвигом");
                        System.out.println("2. Получить элемент по индексу");
                        System.out.println("3. Заменить элемент в заданной позиции новым элементом");
                        System.out.println("4. Отсортировать лист");
                        System.out.println("5. Отобразить в обратном порядке");
                        System.out.println("6. Удалить элемент");
                        System.out.println("7. Найти индекс по элементу");
                        System.out.println("8. Закончить работу");
                        int command3 = scanner.nextInt();
                        switch (command3) {
                            case 1:
                                System.out.println("Введите элемент:");
                                int elem = scanner.nextInt();
                                System.out.println("Введите позицию:");
                                int index = scanner.nextInt();
                                lists[num].replace(index,elem);
                                System.out.println("Получили список:");
                                for(int i = 0;i < lists[num].getCount(); i++) {
                                    System.out.println(lists[num].getElements(i));
                                }
                                break;
                            case 2:
                                System.out.println("Введите индекс:");
                                index = scanner.nextInt();
                                System.out.println(lists[num].get(index));
                                break;
                            case 3:
                                System.out.println("Введите элемент:");
                                elem = scanner.nextInt();
                                System.out.println("Введите позицию:");
                                index = scanner.nextInt();
                                lists[num].replace2(index,elem);
                                System.out.println("Получили список:");
                                for(int i = 0; i < lists[num].getCount(); i++) {
                                    System.out.println(lists[num].getElements(i));
                                }
                                break;
                            case 4:
                                lists[num].sort();
                                System.out.println("Получили список:");
                                for(int i = 0;i < lists[num].getCount(); i++) {
                                    System.out.println(lists[num].getElements(i));
                                }
                                break;
                            case 5:
                                lists[num].reverse();
                                System.out.println("Получили список:");
                                for(int i = 0; i < lists[num].getCount(); i++) {
                                    System.out.println(lists[num].getElements(i));
                                }
                                break;
                            case 6:
                                System.out.println("Введите позицию удаляемого элемента:");
                                index = scanner.nextInt();
                                lists[num].remove(index);
                                System.out.println("Получили список:");
                                for(int i = 0;i < lists[num].getCount(); i++) {
                                    System.out.println(lists[num].getElements(i));
                                }
                                break;
                            case 7:
                                System.out.println("Введите элемент:");
                                elem = scanner.nextInt();
                                System.out.println(lists[num].find(elem));
                                break;
                            case 8:
                                break;
                        }
                        if (command3 == 8) break;
                    } else{
                        System.err.println("Нет такого списка");
                    }
                    break;
                case 4:
                    break;
            }
            if (command == 4) break;
        }
    }
}
