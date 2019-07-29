package com.duoweidu.utils;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.generalAssert.GeneralAssertChannel;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class IqgCallbackInterface extends CallbackInterfaceChannel {

    public final static int channel_id = ConfigFileUrl.getChannel();
    /**
     * GET请求
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String getStringResult(long limitTime, String url, int path_id, String param) {
        HttpGet get = new HttpGet(url + "?" + param);
        get.setHeader("User-Agent","AiQiangGou/5.7.0 (iPhone; iOS 12.0.1; Scale/3.00)");
        get.setHeader("zoneid","21");
        get.setHeader("version", SqlDetail.getInstance().getParamValue(0, "version"));
        get.setHeader("Accept","application/json");
        CallbackInterfaceChannel.defaultHttpClient.setCookieStore(GeneralConfig.store);
        long startTime1 = System.currentTimeMillis();
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GeneralAssertChannel.timeTest(channel_id, limitTime,System.currentTimeMillis()-startTime1, response, url, path_id, param);
        return getResult(channel_id, response, url, path_id, param);
    }

    /**
     * POST请求，LIST
     * @param url
     * @param path_id
     * @param list
     * @return
     */
    public static String postStringResult(long limitTime, String url, int path_id, List<NameValuePair> list) {
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent","AiQiangGou/5.7.0 (iPhone; iOS 12.0.1; Scale/3.00)");
        post.setHeader("zoneid","21");
        post.setHeader("version", SqlDetail.getInstance().getParamValue(0, "version"));
        post.setHeader("Accept","application/json");
        CallbackInterfaceChannel.defaultHttpClient.setCookieStore(GeneralConfig.store);
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
        GeneralAssertChannel.timeTest(channel_id, limitTime, System.currentTimeMillis()-startTime1, response, url, path_id, param);
        return getResult(channel_id, response, url, path_id, list.toString());
    }

    /**
     * post请求，String
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String postStringResult(long limitTime, String url, int path_id, String param) {
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent","AiQiangGou/5.7.0 (iPhone; iOS 12.0.1; Scale/3.00)");
        post.setHeader("zoneid","21");
        post.setHeader("version", SqlDetail.getInstance().getParamValue(0, "version"));
        post.setHeader("Accept","application/json");
        CallbackInterfaceChannel.defaultHttpClient.setCookieStore(GeneralConfig.store);
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
        GeneralAssertChannel.timeTest(channel_id, limitTime, System.currentTimeMillis()-startTime1, response, url, path_id, param);
        return getResult(channel_id, response, url, path_id, param);
    }

    /**
     * delete请求
     * @param url
     * @param path_id
     * @param param
     * @return
     */
    public static String deleteStringResult(long limitTime, String url, int path_id, String param) {
        HttpDelete delete = new HttpDelete(url);
        delete.setHeader("User-Agent","AiQiangGou/5.7.0 (iPhone; iOS 12.0.1; Scale/3.00)");
        delete.setHeader("zoneid","21");
        delete.setHeader("version", SqlDetail.getInstance().getParamValue(0, "version"));
        delete.setHeader("Accept","application/json");
        CallbackInterfaceChannel.defaultHttpClient.setCookieStore(GeneralConfig.store);
        long startTime1 = System.currentTimeMillis();
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GeneralAssertChannel.timeTest(channel_id, limitTime, System.currentTimeMillis()-startTime1, response, url, path_id, param);
        return getResult(channel_id, response, url, path_id, param);
    }

}
