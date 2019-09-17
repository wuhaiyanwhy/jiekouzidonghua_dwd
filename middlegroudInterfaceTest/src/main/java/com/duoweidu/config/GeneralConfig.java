package com.duoweidu.config;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;

import java.util.ArrayList;
import java.util.List;

/**
 * 储存公共接口相关数据
 */
public class GeneralConfig {

    //储存总报错次数
    public static List<Integer> errnoList = new ArrayList<>();
    //储存接口超时时间报错次数
    public static List<String> limitTimeList = new ArrayList<>();


    //用来储存cookies信息的变量
    public static CookieStore store;
    //储存response
    public static HttpResponse response;
    //储存最后一次构建的url
    public static String url;

}
