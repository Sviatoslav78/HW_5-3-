package com.HW_6;


public class NodeForMap<K,V> {

    final K key;
    V value;
    NodeForMap<K,V> next;

    public NodeForMap(K key, V value, NodeForMap<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;

    }
}
