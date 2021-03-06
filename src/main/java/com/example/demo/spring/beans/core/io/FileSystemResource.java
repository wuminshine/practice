package com.example.demo.spring.beans.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 本地文件配置
 */
public class FileSystemResource implements Resource {

    /**
     * 文件路径
     */
    private final String path;

    /**
     * 文件
     */
    private final File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(this.file);
    }

    public String getPath() {
        return path;
    }
}
