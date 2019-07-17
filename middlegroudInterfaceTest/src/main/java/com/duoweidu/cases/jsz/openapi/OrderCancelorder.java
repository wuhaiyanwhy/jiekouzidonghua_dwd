package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderCancelorder extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "取消订单")
    public void orderCancelorder() {
        setUrl("order.createorder.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityId", "10000"));
        process(list, true, false);
    }

}
