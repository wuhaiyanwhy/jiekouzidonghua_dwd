package com.duoweidu.config;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;

import java.util.ArrayList;
import java.util.List;

/**
 * 储存公共接口相关数据
 */
public class GeneralConfig {

    public static List<String> errnoList = new ArrayList<>();


    //用来储存cookies信息的变量
    public static CookieStore store;
    //储存response
    public static HttpResponse response;

}
