package com.company;

public class Rectangle extends Square {
    private int width;
    private int lenght;

    public Rectangle(int side, int width) {
        super(side);
        this.lenght=side;
        this.width = width;
    }

        public void Area(){
            System.out.print("Для прямоугольника");
            System.out.println(" найдем площадь:");
            System.out.print("Площадь фигуры примерна равна - ");
            System.out.println("s = a * b");
            System.out.println("a - длина");
            System.out.println("b - ширина");
            System.out.print("Для данных параметров площадь - ");
            System.out.println(this.lenght*this.width);
        }

}
