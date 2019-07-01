package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.UpdateOrderData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UpdateOrder extends TradeCenterInterfaceTest {

    private UpdateOrderData model;

    @Test(dependsOnGroups = "msfCreateOrder", description = "上送主订单信息")
    public void msfUpdateOrder() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "order.update_order"));
        list.add(new BasicNameValuePair("orderNo", TradecenterConfig.msfCreateOrderOrderNo));
        list.add(new BasicNameValuePair("orderStatus", "dayan"));
        list.add(new BasicNameValuePair("payStatus", "1"));
        list.add(new BasicNameValuePair("settleAmount", "12"));
        list.add(new BasicNameValuePair("commissionAmount", "98"));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(UpdateOrderData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(TradecenterConfig.msfCreateOrderOrderNo, "order_no", model.order_no);
        detailAssertTest("changes", model.changes.toString());
        detailAssertTest("dayan", "changes.order_status", model.changes.order_status);
        detailAssertTest(98, "changes.commission_amount", model.changes.commission_amount);

    }
}
