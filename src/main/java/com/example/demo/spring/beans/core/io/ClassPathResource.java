package com.example.demo.spring.beans.core.io;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 加载classpath下的配置文件
 */
public class ClassPathResource implements Resource {

    /**
     * 文件路径
     */
    private final String path;

    /**
     * 类加载器
     */
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "path can not null");
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader():classLoader;
    }


    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        InputStream inputStream = this.classLoader.getResourceAsStream(this.path);
        if(null == inputStream)
        {
            throw new FileNotFoundException("resource file not found...");
        }
        return inputStream;
    }
}
