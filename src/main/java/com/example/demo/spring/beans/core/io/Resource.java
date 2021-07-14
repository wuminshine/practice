package com.example.demo.spring.beans.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 操作资源文件接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
