package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestConfigOpenapi;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OrderPaymentresult extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "orderPaymentapply",description = "订单支付结果查询")
    public void orderPaymentresult() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_PAYMENTRESULT);
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            list.add(new BasicNameValuePair("order_id", TestConfigOpenapi.orderId));
            list.add(new BasicNameValuePair("trade_no", TestConfigOpenapi.tradeNo));
        }
        process(list,false,false);
    }
}
