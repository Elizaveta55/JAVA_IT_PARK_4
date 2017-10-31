package com.company;

public class Human {
    private String name;
    private int age;

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

//    public String printHuman(Human human){
//        return(human.name + " " + human.age);
//    }

}
