package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderPaymentresult extends MsfInterfaceTest {

    @Test(dependsOnGroups = "orderPaymentapply",description = "订单支付结果查询")
    public void orderPaymentresult() {
        setUrl("order.paymentresult.uri");
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("order_id", MsfConfig.orderId));
            list.add(new BasicNameValuePair("trade_no", MsfConfig.tradeNo));
        }
        process(list,false,false);
    }
}
