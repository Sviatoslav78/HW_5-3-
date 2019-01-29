package com.HW_6;

public class MyHashMap<K, V> {

    NodeForMap<K, V>[] buckets;
    private final static int INITIAL_CAPACITY = 16;
    private int size = 0;

    public MyHashMap() {
        this(INITIAL_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.buckets = new NodeForMap[capacity];
    }



    public void put(K key, V value) {
        NodeForMap<K, V> nodeForMap = new NodeForMap<>(key, value, null);

        int bucket = key.hashCode() % getSize();

        NodeForMap<K, V> existing = buckets[bucket];
        if (existing == null) {

            buckets[bucket] = nodeForMap;
            size++;
        } else {

            while(existing.next != null) {
                if(existing.key.equals(key)) {
                    existing.value = value;
                }
                existing = existing.next;
            }

            if(existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = nodeForMap;
                size++;
            }
        }

    }

    public V get(K key) {
        NodeForMap<K,V> bucket = buckets[key.hashCode() % getSize()];

        while (bucket != null) {
            if(bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

}
