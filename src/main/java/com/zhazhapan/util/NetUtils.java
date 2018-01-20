package com.zhazhapan.util;

import com.zhazhapan.modules.constant.Values;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author pantao
 * @date 2018/1/19
 */
public class NetUtils {

    private NetUtils() {}

    /**
     * 获取URL中的数据
     *
     * @param url 网络链接
     *
     * @return {@link String}
     *
     * @throws IOException 异常
     */
    public static String getDataOfUrl(String url) throws IOException {
        return getDataOfUrl(new URL(url));
    }

    /**
     * 获取URL中的数据
     *
     * @param url 网络链接
     *
     * @return {@link String}
     *
     * @throws IOException 异常
     */
    public static String getDataOfUrl(URL url) throws IOException {
        return FileExecutor.read(getInputStreamOfUrl(url));
    }

    /**
     * 获取URL的InputStream对象
     *
     * @param url 网络链接
     *
     * @return {@link InputStream}
     *
     * @throws IOException 异常
     */
    public static InputStream getInputStreamOfUrl(String url) throws IOException {
        return getInputStreamOfUrl(new URL(url));
    }

    /**
     * 获取URL的InputStream对象
     *
     * @param url 网络链接
     *
     * @return {@link InputStream}
     *
     * @throws IOException 异常
     */
    public static InputStream getInputStreamOfUrl(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        return getInputStreamOfConnection(conn);
    }

    /**
     * 获取HttpURLConnection的InputStream对象
     *
     * @param connection 链接对象
     *
     * @return {@link InputStream}
     *
     * @throws IOException 异常
     */
    public static InputStream getInputStreamOfConnection(HttpURLConnection connection) throws IOException {
        connection.setConnectTimeout(1000 * 6);
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setRequestProperty("User-Agent", Values.USER_AGENT);
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Accept", "*/*");
        return connection.getInputStream();
    }
}