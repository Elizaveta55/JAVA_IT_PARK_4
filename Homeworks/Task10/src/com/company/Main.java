package com.company;

public class Main {

    public static void main(String[] args) {
        PrinterOfIterable printerOfIterable = new PrinterOfIterable();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add("four");
        linkedList.add("five");
        linkedList.add(6);
        linkedList.add(7);

        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add("two");
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add("six");

        Iterator iteratorLink = linkedList.iterator();
        printerOfIterable.print(iteratorLink);

        Iterator iteratorArray = arrayList.iterator();
        printerOfIterable.print(iteratorArray);
    }
}
