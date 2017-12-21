package com.company;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ArrayList array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.doForEach();
        Stream<Integer> current = array.goFilter();
        System.out.println(current);
        current = array.goMap();
        System.out.println(current);

        LinkedList list = new LinkedList<Integer>();
        list.add(1);
        list.add(10);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(6);
        list.add(6);
        list.doForEach();
        current = list.doFilter();
        System.out.println(current);
        current = list.doMap();
        System.out.println(current);
    }
}
