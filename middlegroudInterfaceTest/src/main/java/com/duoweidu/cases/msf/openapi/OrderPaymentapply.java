package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.OrderPaymentapplyData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderPaymentapply extends MsfInterfaceTest {

    private OrderPaymentapplyData model;

    @Test(dependsOnGroups = "loginTrue",description = "支付提交接口",groups = "orderPaymentapply")
    public void orderPaymentapply() {
        setUrl("order.paymentapply.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activity_id", SqlDetail.getInstance().getParamValue(2, "pay_activity_id")));
        list.add(new BasicNameValuePair("pay_channel_id",SqlDetail.getInstance().getParamValue(0, "pay_channel_id")));
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(OrderPaymentapplyData.class);
            detailAssert();
            SqlDetail.getInstance().msfUpdateOrder();
            MsfConfig.orderId = String.valueOf(model.order_id);
            MsfConfig.tradeNo = model.trade_no;
        }
    }

    private void detailAssert() {
        assertNotEmpty("result", model.result);
        assertNotEmpty("order_id", model.order_id);
        assertNotEmpty("amount", model.amount);
        assertNotEmpty("order_no", model.order_no);
        assertNotEmpty("trade_no", model.trade_no);
        assertNotEmpty("pay_sign_data", model.pay_sign_data);
    }
}
