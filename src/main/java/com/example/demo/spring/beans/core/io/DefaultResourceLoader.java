package com.example.demo.spring.beans.core.io;

import org.springframework.util.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String path) {
        Assert.notNull(path, "path must not be null");
        // 以classpath开头
        if(path.startsWith(CLASS_PATH_PREFIX))
        {
            return new ClassPathResource(path.substring(CLASS_PATH_PREFIX.length()));
        }
        else
        {
            try {
                URL url = new URL(path);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
//                e.printStackTrace();
                // 远程资源文件
                return new FileSystemResource(path);
            }
        }
    }
}
