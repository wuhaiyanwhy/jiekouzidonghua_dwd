package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderPaymentapply extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付提交接口",groups = "orderPaymentapply")
    public void orderPaymentapply() {
        setUrl("order.paymentapply.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activity_id", SqlDetail.getParamValue(2, "pay_activity_id")));
        list.add(new BasicNameValuePair("pay_channel_id",SqlDetail.getParamValue(0, "pay_channel_id")));
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            SqlDetail.msfUpdateOrder();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            MsfConfig.orderId = data.get("order_id").toString();
            MsfConfig.tradeNo = data.get("trade_no").toString();
        }
    }
}
