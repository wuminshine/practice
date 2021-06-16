package com.example.demo.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap 死循环调测
 */
public class HashMapEndlessDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(3, "B");
        map.put(1, "A");
    }
}
