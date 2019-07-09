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

public class OrderCancel extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "orderPaymentapply",description = "取消订单")
    public void orderCancel() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_CANCEL);
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            list.add(new BasicNameValuePair("order_id", TestConfigOpenapi.orderId));
        }
        process(list,false,false);
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            generalAssertTest(false);
        }
    }
}
