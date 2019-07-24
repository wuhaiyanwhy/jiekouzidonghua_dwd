package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;


public class OrderOrderdetail extends JszInterfaceTest {

    @Test(description = "订单详情")
    public void orderOrderdetail() {
        setUrl("order.orderlist.uri");
        param = "activityId=" + SqlDetail.getInstance().getParamValue("activityId");
        process(true, false);
    }
}
