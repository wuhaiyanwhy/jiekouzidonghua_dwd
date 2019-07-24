package com.duoweidu.cases.message;

import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.LinkedList;
import java.util.List;

/**
 * 短信提醒
 */

public class Message {

    public static void sendMessage(String content, String mobile, String appId) {
        String url = ConfigFileUrl.getUrlByKey(7, 0,  "sms.sendbysoap.uri");
        System.out.println(url);
        System.out.println();
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile", mobile));
        list.add(new BasicNameValuePair("sendType", "1"));
        list.add(new BasicNameValuePair("content", content));
        list.add(new BasicNameValuePair("appId", appId));
        CallbackInterface.postStringResult(ConfigFileUrl.getLimitTime(), url, 2, list);
    }
}

