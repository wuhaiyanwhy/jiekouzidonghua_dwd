package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestConfigOpenapi;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OrderPaymentapply extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付提交接口",groups = "orderPaymentapply")
    public void orderPaymentapply() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_PAYMENTAPPLY);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activity_id", TestSql.getValue("pay_activity_id",2)));
        list.add(new BasicNameValuePair("pay_channel_id",TestSql.getValue("pay_channel_id",4)));
        list.add(new BasicNameValuePair("platform",TestSql.getValue("platform",4)));
        list.add(new BasicNameValuePair("zone_id",TestSql.getValue("zone_id",4)));
        process(list,false,false);
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            generalAssertTest(false);
            TestSql.updateOrder();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            TestConfigOpenapi.orderId = data.get("order_id").toString();
            TestConfigOpenapi.tradeNo = data.get("trade_no").toString();
        }
    }
}
