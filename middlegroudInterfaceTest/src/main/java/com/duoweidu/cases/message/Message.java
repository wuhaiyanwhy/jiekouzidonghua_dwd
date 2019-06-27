package com.duoweidu.cases.message;

import com.duoweidu.config.SqlTradecenter;
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

    public static void sendMessage(String mobile) {
        String url = ConfigFileUrl.getUrlByKey(7, 0,  "smsSendbysoap");
//        String url = "http://message.center.haoshiqi.net/sms/sendbysoap";
        System.out.println(url);
        System.out.println();
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile", mobile));
        list.add(new BasicNameValuePair("sendType", "1"));
        list.add(new BasicNameValuePair("content", "【中台】接口已经多次报错了，快去钉钉查看测试报告！！！"));
//        list.add(new BasicNameValuePair("appId", SqlTradecenter.getTradeCenterParamValue(0, "appId")));
        CallbackInterface.postStringResult(url, 2, list);
    }
}

