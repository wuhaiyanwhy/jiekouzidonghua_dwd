package com.duoweidu.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;

/**
 * 储存公共接口相关数据
 */
public class GeneralConfig {

    public static List<String> errnoList = new ArrayList<>();

    static {
        defaultHttpClient = new DefaultHttpClient();
    }

    //用来储存cookies信息的变量
    public static CookieStore store;
    //声明http客户端
    public static DefaultHttpClient defaultHttpClient;


}
