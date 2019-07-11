package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ugc_usercomment_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "评价")
    public void ugc_usercomment_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.UGC_USERCOMMENT);
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
