package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.model.msf.OrderCancelData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderCancel extends MsfInterfaceTest {

    private OrderCancelData model;

    @Test(dependsOnGroups = "orderPaymentapply",description = "取消订单")
    public void orderCancel() {
        setUrl("order.cancel.uri");
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("order_id", MsfConfig.orderId));
        }
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(OrderCancelData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        assertEquals("result", model.result, "success");
        assertNotEmpty("tips", model.tips);

    }
}
