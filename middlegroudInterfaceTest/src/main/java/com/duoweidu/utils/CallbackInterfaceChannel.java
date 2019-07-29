package com.duoweidu.utils;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.generalAssert.GeneralAssertChannel;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class CallbackInterfaceChannel {

    public static DefaultHttpClient defaultHttpClient;

    static {
        defaultHttpClient = new DefaultHttpClient();
    }

    /**
     * 获取请求结果并加基本断言
     * @param channel_id
     * @param response
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String getResult(int channel_id, HttpResponse response, String url, int path_id, String param) {
        GeneralConfig.response = response;
        GeneralAssertChannel.codeAssert(channel_id, response, url, path_id, param);
        String result = null;
        try {
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ( response.getEntity() != null ) {
            try {
                response.getEntity().getContent().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("接口返回：" + result);
        GeneralAssertChannel.resultAssert(channel_id, url, path_id, param, result);
        return result;

    }

    /**
     * GET请求
     * @param channel_id
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String getStringResult(int channel_id, long limitTime,  String url, int path_id, String param) {
        HttpGet get = new HttpGet(url + "?" + param);
        defaultHttpClient.setCookieStore(GeneralConfig.store);
        long startTime1 = System.currentTimeMillis();
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GeneralAssertChannel.timeTest(channel_id, limitTime, System.currentTimeMillis()-startTime1, response, url, path_id, param );
        return getResult(channel_id, response, url, path_id, param);
    }

    /**
     * POST请求，LIST
     * @param channel_id
     * @param url
     * @param path_id
     * @param list
     * @return
     */
    public static String postStringResult(int channel_id, long limitTime, String url, int path_id, List<NameValuePair> list) {
        HttpPost post = new HttpPost(url);
        defaultHttpClient.setCookieStore(GeneralConfig.store);
        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(list, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);
        long startTime1 = System.currentTimeMillis();
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String param = URLEncodedUtils.format(list, "Utf-8");
        GeneralAssertChannel.timeTest(channel_id, limitTime, System.currentTimeMillis()-startTime1, response, url, path_id, param );
        return getResult(channel_id, response, url, path_id, list.toString());
    }

    /**
     * post请求，String
     * @param channel_id
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String postStringResult(int channel_id, long limitTime, String url, int path_id, String param) {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        defaultHttpClient.setCookieStore(GeneralConfig.store);
        StringEntity entity = null;
        try {
            entity = new StringEntity(param, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);
        long startTime1 = System.currentTimeMillis();
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GeneralAssertChannel.timeTest(channel_id, limitTime, System.currentTimeMillis()-startTime1, response, url, path_id, param );
        return getResult(channel_id, response, url, path_id, param);
    }

    /**
     * delete请求
     * @param channel_id
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String deleteStringResult(int channel_id, long limitTime, String url, int path_id, String param) {
        HttpDelete delete = new HttpDelete(url);
        defaultHttpClient.setCookieStore(GeneralConfig.store);
        long startTime1 = System.currentTimeMillis();
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GeneralAssertChannel.timeTest(channel_id, limitTime, System.currentTimeMillis()-startTime1, response, url, path_id, param );
        return getResult(channel_id, response, url, path_id, param);
    }

}
