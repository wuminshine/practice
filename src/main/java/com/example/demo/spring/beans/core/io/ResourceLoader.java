package com.example.demo.spring.beans.core.io;

public interface ResourceLoader {

    String CLASS_PATH_PREFIX = "classpath:";

    Resource getResource(String path);
}
