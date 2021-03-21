package com.nathan.hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private Integer capacity;
    private static final long serialVersionUID = 1L;

    //带参数的构造器
    public LRUCache(int capacity) {
        //调用 LinkedHashMap 的构造器，传入以下参数
        super(16, 0.75f, true);
        //指定的缓存最大容量
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }
}
