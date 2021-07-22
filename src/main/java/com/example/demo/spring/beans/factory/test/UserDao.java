package com.example.demo.spring.beans.factory.test;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    static Map<String, String> userMap = new HashMap<>();
    public void initMethod()
    {
        System.out.println("执行userdao的init方法");
        userMap.put("1", "qqqq");
        userMap.put("2", "wwww");
        userMap.put("3", "dddd");
    }

    public void destroyMethod()
    {
        System.out.println("执行UserDao销毁方法");
    }

    public String getUser(String userId)
    {
        return userMap.get(userId);
    }
}
