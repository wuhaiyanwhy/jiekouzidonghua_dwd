package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 无法一直评价，暂时无需通用断言
 */
public class ugc_usercomment_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "评价")
    public void ugc_usercomment_true() {
        setUrl("ugc.usercomment.uri");
        System.out.println();
        List<NameValuePair> list = new LinkedList<>();
        //无待评价订单，禁用
//        BasicNameValuePair param1 = new BasicNameValuePair("content", "测试");
//        BasicNameValuePair param2 = new BasicNameValuePair("deliveryScore", "5");
//        BasicNameValuePair param3 = new BasicNameValuePair("merchantScore", "5");
//        BasicNameValuePair param4 = new BasicNameValuePair("score", "5");
//        BasicNameValuePair param5 = new BasicNameValuePair("subOrderId", "16488034");
//        list.add(param1);
//        list.add(param2);
//        list.add(param3);
//        list.add(param4);
//        list.add(param5);
        process(list,false,false);
    }
}
