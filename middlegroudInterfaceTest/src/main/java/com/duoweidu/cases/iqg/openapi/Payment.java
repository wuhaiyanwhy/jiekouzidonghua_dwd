package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.IqgConfig;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Payment extends IqgInterfaceTest {

    @Test(dependsOnGroups = "orderTrue",description = "支付")
    public void payment_true() {
        setUrl("payment.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("order_id", IqgConfig.orderId));
        list.add(new BasicNameValuePair("alipay","0.010000"));
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}
