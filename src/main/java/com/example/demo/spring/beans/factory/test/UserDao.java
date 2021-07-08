package com.example.demo.spring.beans.factory.test;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    static Map<String, String> userMap = new HashMap<>();
    static
    {
        userMap.put("1", "qqqq");
        userMap.put("2", "wwww");
        userMap.put("3", "dddd");
    }

    public String getUser(String userId)
    {
        return userMap.get(userId);
    }
}
