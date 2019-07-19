package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderBeforecreate extends JszInterfaceTest {

    @Test(description = "提交订单")
    public void orderBeforecreate() {
        setUrl("order.beforecreate.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityId", SqlDetail.getInstance().getParamValue("activityId")));
        process(list,true, false);
    }
}

