package com.company;

public class HashMap<K,V> implements Map<K, V> {

    public static class Node<Key, Value> {
        Key key;
        Value value;
        Node<Key, Value> next;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    public static class Sset<Key>{
        Key key;
        Sset<Key> next;

        Sset(Key key){
            this.key = key;
        }
    }

    private Node<K, V> buckets[] = new Node[16];
    private Sset<K> setOfKeys [] = new Sset[16];
    private int count=1;

    @Override
    public Sset<K>[] keySet(K key){

        boolean flag = false;
        if (setOfKeys[0] == null) {
            Sset<K> newNode = new Sset<>(key);
            setOfKeys[count-1] = newNode;
            return setOfKeys;
        }
        else {
            Sset<K> current = setOfKeys[0];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    flag = true;
                    break;
                }
                current = current.next;
            }
            if (current.next == null){
                if (current.key.equals(key)) {
                    flag = true;
                }
            }
            if (!flag){
                Sset<K> newNode = new Sset<>(key);
                setOfKeys[count] = newNode;
                count++;
                current.next = newNode;
            }
        }
        return setOfKeys;
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash & buckets.length - 1;
        if (buckets[index] == null) {
            Node<K,V> newNode = new Node<>(key, value);
            buckets[index] = newNode;
        } else {

            Node<K,V> current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            Node<K,V> newNode = new Node<>(key, value);
            current.next = newNode;
        }
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int index = hash & buckets.length - 1;
        if (buckets[index] == null) {
            return null;
        }
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
}
