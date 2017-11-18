package com.company;


public interface Map<K, V> {
    HashMap.Sset<K>[] keySet(K key);
    void put(K key, V value);
    V get (K key);
}
