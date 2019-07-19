package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;


public class OrderCancreateorder extends JszInterfaceTest {

    @Test(description = "检测是否可以购买")
    public void orderCancreateorder() {
        setUrl("order.cancreateorder.uri");
        param = "activityId=" + SqlDetail.getInstance().getParamValue("activityId");
        process(true, false);
    }
}
