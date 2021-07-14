package com.example.demo.spring.beans.core.io;

import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 远程资源文件
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        try {
            return urlConnection.getInputStream();
        }
        catch (IOException ex)
        {
            if (urlConnection instanceof HttpURLConnection)
            {
                ((HttpURLConnection) urlConnection).disconnect();
            }
            throw ex;
        }
    }
}
