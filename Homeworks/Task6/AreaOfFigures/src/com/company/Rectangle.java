package com.company;

public class Rectangle extends Shape {
    private String name;

    public Rectangle(String name){
        this.name=name;
    }

        public void Area(){
            System.out.print("Для ");
            System.out.print(name);
            System.out.println(" найдем площадь:");
            System.out.print("Площадь фигуры примерна равна - ");
            System.out.println("s = a * b");
            System.out.println("a - длина");
            System.out.println("b - ширина");
            System.out.println();
        }

}
