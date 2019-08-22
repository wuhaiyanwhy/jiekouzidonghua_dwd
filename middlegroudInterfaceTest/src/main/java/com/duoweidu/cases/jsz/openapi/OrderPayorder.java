package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.JszConfig;
import com.duoweidu.model.jsz.OrderCreateorderData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderPayorder extends JszInterfaceTest {

    private OrderCreateorderData model;

    @Test(dependsOnGroups = "OrderCreateorder", groups = "OrderPayorder", description = "支付")
    public void orderPayorder() {
        setUrl("order.payorder.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("id", JszConfig.order_id));
        process(list, true, false);
        model = sparseJson(OrderCreateorderData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("order_id", model.order_id);
        detailAssertTest("payment_id", model.payment_id);
        for (int i = 0; i < model.sign_data.size(); i++) {
            detailAssertTest("appId", model.sign_data.get(i).appId);
            detailAssertTest("timeStamp", model.sign_data.get(i).timeStamp);
            detailAssertTest("nonceStr", model.sign_data.get(i).nonceStr);
//            detailAssertTest("",model.sign_data.get(i).package);
            detailAssertTest("signType", model.sign_data.get(i).signType);
            detailAssertTest("paySign", model.sign_data.get(i).paySign);
        }
    }
}
