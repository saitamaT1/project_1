package com.ultraneos.mall.util;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Saitama
 * @since 2022/06/28 11:50
 */

public class HttpUtils {
    public static String getRequestBody(HttpServletRequest req) throws IOException {
        ServletInputStream inputStream = req.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int length;
        byte[] bytes = new byte[1024];
        while ((length=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,length);
        }
        String reqBody = outputStream.toString("utf-8");
        return reqBody;
    }
}
