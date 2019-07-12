package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ActivitySubscribe extends HsqInterfaceTest {

    private ResData model;

    @Test(description = "订阅助力")
    public void activitySubscribe() {
        setUrl("activity.subscribe.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("token", SqlDetail.getParamValue("token")));
        list.add(new BasicNameValuePair("activityId", SqlDetail.getParamValue(2, "subscribeActivityId")));
        list.add(new BasicNameValuePair("subscribe", "1"));
        list.add(new BasicNameValuePair("activityType", "1"));

        process(list, false, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ResData.class);
            detailAssert();
        }

    }

    @Test(description = "取消订阅")
    public void activitySubscribeCancel() {
        setUrl("activity.subscribe.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("token", SqlDetail.getParamValue("token")));
        list.add(new BasicNameValuePair("activityId", SqlDetail.getParamValue(2, "subscribeActivityId")));
        list.add(new BasicNameValuePair("subscribe", "2"));
        list.add(new BasicNameValuePair("activityType", "1"));

        process(list, false, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ResData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }
}
