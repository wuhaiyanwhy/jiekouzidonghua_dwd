package com.duoweidu.utils;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.GeneralConfig;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 接口调用相关
 */

public class CallbackInterface {
    private static final DefaultHttpClient defaultHttpClient;

    static {
        defaultHttpClient = new DefaultHttpClient();
    }

    /**
     * 获取请求结果并加基本断言
     * @param response
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String getResult(HttpResponse response, String url, int path_id, String param) {
        GeneralConfig.response = response;
        GeneralAssert.codeAssert(response, url, path_id, param);
        String result = null;
        try {
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ( response.getEntity() != null ) {
            try {
                response.getEntity().consumeContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("接口返回：" + result);
        GeneralAssert.resultAssert(url, path_id, param, result);
        return result;

    }

    /**
     * GET请求
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String getStringResult(String url, int path_id, String param) {
        HttpGet get = new HttpGet(url + "?" + param);
        GeneralConfig.defaultHttpClient.setCookieStore(GeneralConfig.store);
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResult(response, url, path_id, param);
    }

    /**
     * POST请求，LIST
     * @param url
     * @param path_id
     * @param list
     * @return
     */
    public static String postStringResult(String url, int path_id, List<NameValuePair> list) {
        HttpPost post = new HttpPost(url);
        GeneralConfig.defaultHttpClient.setCookieStore(GeneralConfig.store);
        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(list, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResult(response, url, path_id, list.toString());
    }

    /**
     * post请求，String
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String postStringResult(String url, int path_id, String param) {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        GeneralConfig.defaultHttpClient.setCookieStore(GeneralConfig.store);
        StringEntity entity = null;
        try {
            entity = new StringEntity(param, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResult(response, url, path_id, param);
    }

    /**
     * delete请求
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String deleteStringResult(String url, int path_id, String param) {
        HttpDelete delete = new HttpDelete(url);
        GeneralConfig.defaultHttpClient.setCookieStore(GeneralConfig.store);
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResult(response, url, path_id, param);
    }

}
