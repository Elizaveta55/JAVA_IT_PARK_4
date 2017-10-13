package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введи номер фигуры, площадь которого требуется найти.");
        System.out.println("1. Круг");
        System.out.println("2. Шар");
        System.out.println("3. Прямоугольник");
        System.out.println("4. Квадрат");
        System.out.println("5. Треугольник");
        System.out.println("6. Параллелограмм");
        Scanner scanner = new Scanner(System.in);

        int command = scanner.nextInt();
        switch (command){
            case 1:
                System.out.println("Введите значение радиуса");
                int radius = scanner.nextInt();
                Circle circle = new Circle(radius);
                Shape figure = circle;
                figure.Area();
                break;
            case 2:
                System.out.println("Введите значение радиуса");
                radius = scanner.nextInt();
                Sphere sphere = new Sphere(radius);
                Shape figure1 = sphere;
                figure1.Area();
                break;
            case 3:
                System.out.println("Введите значения ширины и длины");
                int width = scanner.nextInt();
                int lenght = scanner.nextInt();
                Rectangle rectangle = new Rectangle(lenght, width);
                Shape figure2 = rectangle;
                figure2.Area();
                break;
            case 4:
                System.out.println("Введите значение стороны квадрата");
                int side = scanner.nextInt();
                Square square = new Square(side);
                Shape figure3 = square;
                figure3.Area();
                break;
            case 5:
                System.out.println("Введите значения основания и высоты");
                side = scanner.nextInt();
                int h = scanner.nextInt();
                Triangle triangle = new Triangle(side, h);
                Shape figure4 = triangle;
                figure4.Area();
                break;
            case 6:
                System.out.println("Введите значения основания и высоты");
                side = scanner.nextInt();
                h = scanner.nextInt();
                Parallelogram parallelogram = new Parallelogram(side, h);
                Shape figure5 = parallelogram;
                figure5.Area();
                break;
        }
    }
}
