package com.example.demo.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<CustomKey, String> treeMap = new HashMap<>();
        CustomKey key1 = new CustomKey("1");
        CustomKey key2 = new CustomKey("2");
        treeMap.put(key1, "aaa");
        treeMap.put(key2, "ccc");
        treeMap.put(key1, "bbb");
        treeMap.forEach((k, v) -> System.out.println("key:" + k + ", value:" + v));
    }
}
