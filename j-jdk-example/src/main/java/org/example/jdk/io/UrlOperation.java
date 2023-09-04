package org.example.jdk.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ClassName: UrlOperation
 * Description: 读取url内容
 *
 * @author Yuliang Lau
 * @date 2023/9/4 18:02
 */
public class UrlOperation {
    public String parseUrl(String url) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            URL sjwurl = null;
            HttpURLConnection httpUrl = null;
            BufferedInputStream bis = null;
            byte[] buf = new byte[1024];

            sjwurl = new URL(url);
            httpUrl = (HttpURLConnection) sjwurl.openConnection();
            httpUrl.connect();
            java.io.InputStream is = httpUrl.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = -1;
            while ((b = is.read()) > 0) {
                baos.write(b);
            }
            is.close();
            httpUrl.disconnect();

            return baos.toString();
        } catch (Exception e) {
            System.out.println("err!");
            return null;
        }
    }
}
