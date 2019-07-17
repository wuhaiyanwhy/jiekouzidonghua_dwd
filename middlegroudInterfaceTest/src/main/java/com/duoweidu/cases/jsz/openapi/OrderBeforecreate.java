package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderBeforecreate extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "提交订单")
    public void orderBeforecreate() {
        setUrl("order.beforecreate.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityId", "10000"));
        process(list,true, false);
    }
}

