package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.JszConfig;
import com.duoweidu.model.jsz.OrderCancelorderData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderCancelorder extends JszInterfaceTest {

    private OrderCancelorderData model;

    @Test(dependsOnGroups = "orderOrderlist2",description = "取消订单")
    public void orderCancelorder() {
        setUrl("order.cancelorder.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("id", JszConfig.order_id));
        process(list, true, false);
        model = sparseJson(OrderCancelorderData.class);
        detailAssert();
    }

    private void detailAssert(){
        detailAssertTest("id",model.id);
    }

}
