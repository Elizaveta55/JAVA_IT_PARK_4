package com.company;

public class PrinterOfIterable {
    public void print(Iterator iterator) {
        while (iterator.HasNext()) {
            System.out.println(iterator.next());
        }
    }
}
