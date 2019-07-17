package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderCancreateorder extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "检测是否可以购买")
    public void orderCancreateorder() {
        setUrl("order.cancreateorder.uri");
        List<NameValuePair> list = new LinkedList<>();
        param = "activityId=" + SqlDetail.getInstance().getParamValue("activityId");
        process(true, false);
    }
}
