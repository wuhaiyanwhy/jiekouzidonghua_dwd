package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlDetail;
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
        list.add(new BasicNameValuePair("orderStatus", SqlDetail.getParamValue(0, "orderStatus")));
        list.add(new BasicNameValuePair("payStatus", SqlDetail.getParamValue(0, "payStatus")));
        list.add(new BasicNameValuePair("settleAmount", SqlDetail.getParamValue(0, "settleAmount")));
        list.add(new BasicNameValuePair("commissionAmount", SqlDetail.getParamValue(0, "commissionAmount")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(UpdateOrderData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(TradecenterConfig.msfCreateOrderOrderNo, "order_no", model.order_no);
        detailAssertTest("changes", model.changes.toString());
        detailAssertTest(SqlDetail.getParamValue(0, "orderStatus"), "changes.order_status", String.valueOf(model.changes.order_status));
        detailAssertTest(SqlDetail.getParamValue(0, "commissionAmount"), "changes.commission_amount", String.valueOf(model.changes.commission_amount));

    }
}
