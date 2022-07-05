package com.ultraneos.mall.util;

import java.text.SimpleDateFormat;

/**
 * @ClassName Constant
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2022/5/20 9:37
 * @Version V1.0
 **/
public class Constant {

    /**
     * 当前应用所在的主机、端口号
     */
    // public static final String DOMAIN = "http://localhost:8084/";
    public static final String DOMAIN = "http://192.168.3.79:8084/";

    /**
     * 前端页面所在的主机、端口号
     */
    // public static final String ORIGIN = "http://localhost:8085";
    public static final String ORIGIN = "http://192.168.3.79:8085";

    public static final int SUCCESS_CODE = 200;

    public static final int NOT_FOUND_CODE = 404;

    public static final int NO_REPLY_CODE = 1;

    public static final int REPLY_CODE = 0;

    public static final boolean COMMENT_CODE = true;

    public static final boolean NO_COMMENT_CODE = false;

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
