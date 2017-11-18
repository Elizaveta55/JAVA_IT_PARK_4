package com.company;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
	 Map<String, Integer> map = new HashMap<>();

        map.put("Алексей", 27);
        map.put("Алмаз", 25);
        map.put("Загир", 26);
        map.put("Радик", 24);
        map.put("Марс", 24);
        map.put("Антон", 18);
        map.put("Алия", 21);
        map.put("Даниил", 25);
        map.put("Андрей", 19);
        map.put("Елизавета", 19);
        map.put("Руслан", 47);
        map.put("Артур", 18);

        System.out.println(map.get("Алексей"));
        System.out.println(map.get("Алмаз"));
        System.out.println(map.get("Загир"));
        System.out.println(map.get("Радик"));
        System.out.println(map.get("Марс"));
        System.out.println(map.get("Антон"));
        System.out.println(map.get("Алия"));
        System.out.println(map.get("Даниил"));
        System.out.println(map.get("Андрей"));
        System.out.println(map.get("Елизавета"));
        System.out.println(map.get("Руслан"));
        System.out.println(map.get("Артур"));
        System.out.println(map.get("Авраам"));

        HashMap.Sset<String> keySets[] =  map.keySet("Алмаз");
        keySets =  map.keySet("Марс");
        keySets =  map.keySet("Елизавета");
        keySets =  map.keySet("Алмаз");
        keySets =  map.keySet("Марс");
        keySets =  map.keySet("Елизавета");
        keySets =  map.keySet("Андрей");
        keySets =  map.keySet("Алексей");
        keySets =  map.keySet("Радик");
        keySets =  map.keySet("Загир");
        keySets =  map.keySet("Загир");
        keySets =  map.keySet("Алмаз");

        System.out.println();
        for (int i = 0; i < 16; i++){
            if (keySets[i]!= null) {
                System.out.println(keySets[i].key);
            }
        }
    }
}
