package com.wzb.douyin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * IO 操作工具类
 *
 * @author Guan Yongchao
 */
public class IoUtil {

    /**
     * 连接超时时间
     */
    private static final int CONNECT_TIMEOUT = 1000 * 10;

    private IoUtil() {
    }

    /**
     * 下载文件到指定目录.
     *
     * @param link     网络链接
     * @param filePath 保存路径,包含文件名及后缀
     * @throws IOException
     */
    public static void download(String link, String filePath) throws IOException {
        try (InputStream is = getInputStreamByUrl(link);
             OutputStream os = new FileOutputStream(filePath)) {
            IoUtil.write(is, os);
        }
    }

    /**
     * 下载文件
     *
     * @param url
     * @param fileName
     * @param response
     * @throws IOException
     */
    public static void download(final String url, String fileName, HttpServletResponse response) throws IOException {
        if (StringUtils.isEmpty(url)) {
            throw new IllegalArgumentException("field is empty.");
        }
        if (null == response) {
            throw new IllegalArgumentException("response is null.");
        }

        try (InputStream is = getInputStream(url);
             OutputStream os = response.getOutputStream()) {

            response.reset();
            response.setContentType(ContentType.APPLICATION_OCTET_STREAM.getMimeType());
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

            IoUtil.write(is, os);
            os.flush();
        }
    }

    /**
     * 字节流写入
     *
     * @param is
     * @param os
     * @throws IOException
     */
    public static void write(InputStream is, OutputStream os) throws IOException {
        int len;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) > 0) {
            os.write(buffer, 0, len);
        }
    }

    /**
     * 关闭
     *
     * @param closeable 被关闭的对象
     */
    public static void close(Closeable... closeable) {
        if (closeable != null) {
            for (Closeable item : closeable) {
                try {
                    item.close();
                } catch (IOException e) {
                    // 静默关闭
                }
            }
        }
    }

    /**
     * 从缓存中刷出数据
     *
     * @param flushable
     */
    public static void flush(Flushable flushable) {
        if (null != flushable) {
            try {
                flushable.flush();
            } catch (Exception e) {
                // 静默刷出
            }
        }
    }

    /**
     * 获取从连接打开的输入流
     *
     * @param link
     * @return
     * @throws IOException
     */
    public static InputStream getInputStreamByUrl(String link) throws IOException {
        URLConnection con = new URL(link).openConnection();
        con.setConnectTimeout(CONNECT_TIMEOUT);
        return con.getInputStream();
    }

    public static InputStream getInputStream(String url) throws IOException {
        return url.startsWith("http") ? getInputStreamByUrl(url) : new FileInputStream(url);
    }


    public static void serverResponse(HttpServletResponse response, Object result) throws IOException {
        Assert.notNull(result, "Result must be not null.");
        serverResponse(response, JSON.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty));
    }

    public static void serverResponse(HttpServletResponse response, String json) throws IOException {
        serverResponse(response, HttpStatus.SC_OK, json);
    }

    public static void serverResponse(HttpServletResponse response, int status, String json) throws IOException {
        Assert.isTrue(response != null, "Response must be not null.");
        response.setStatus(status);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        OutputStream writer = response.getOutputStream();
        writer.write(json.getBytes());
        writer.flush();
        writer.close();
    }
}