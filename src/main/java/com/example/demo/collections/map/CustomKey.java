package com.example.demo.collections.map;

public class CustomKey implements Comparable<CustomKey> {
    String id;
    public CustomKey(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomKey{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public int compareTo(CustomKey o) {
        return this.id.compareTo(o.getId());
    }
}
