package com.duoweidu.utils;

import org.apache.http.NameValuePair;
import java.util.List;

/**
 * 接口调用相关
 */

public class CallbackInterface extends CallbackInterfaceChannel{

    public final static int channel_id = ConfigFileUrl.getChannel();

    /**
     * GET请求
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String getStringResult(long limitTime, String url, int path_id, String param) {
        return CallbackInterfaceChannel.getStringResult(channel_id, limitTime, url, path_id, param);
    }

    /**
     * POST请求，LIST
     * @param url
     * @param path_id
     * @param list
     * @return
     */
    public static String postStringResult(long limitTime, String url, int path_id, List<NameValuePair> list) {
        return CallbackInterfaceChannel.postStringResult(channel_id, limitTime, url, path_id, list);
    }

    /**
     * post请求，String
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String postStringResult(long limitTime, String url, int path_id, String param) {
        return CallbackInterfaceChannel.postStringResult(channel_id, limitTime, url, path_id, param);
    }

    /**
     * delete请求
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String deleteStringResult(long limitTime, String url, int path_id, String param) {
        return CallbackInterfaceChannel.deleteStringResult(channel_id, limitTime, url, path_id, param);
    }

}
