package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.JszConfig;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderPayorder extends JszInterfaceTest {

    @Test(dependsOnGroups = "OrderCreateorder",description = "支付")
    public void orderPayorder() {
        setUrl("order.payorder.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("id", JszConfig.order_id));
        process(list, true, false);
    }
}
