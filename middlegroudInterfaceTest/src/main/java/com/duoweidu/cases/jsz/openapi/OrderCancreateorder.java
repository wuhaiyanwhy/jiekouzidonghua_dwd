package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.OrderCancreateorderData;
import org.testng.annotations.Test;


public class OrderCancreateorder extends JszInterfaceTest {

//    private OrderCancreateorderData model;

    @Test(description = "检测是否可以购买")
    public void orderCancreateorder() {
        setUrl("order.cancreateorder.uri");
        param = "activityId=" + SqlDetail.getInstance().getParamValue("activityId");
        process(false, false);
//        model = sparseJson(OrderCancreateorderData.class);
//        detailAssert();
    }
//    private void detailAssert(){
//        detailAssertTest("true","ret",model.ret);
//    }
}
