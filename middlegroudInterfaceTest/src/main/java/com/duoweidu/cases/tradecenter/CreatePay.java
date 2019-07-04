package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.CreatePayData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CreatePay extends TradeCenterInterfaceTest {

    private CreatePayData model;

    @Test(dependsOnGroups = "msfCreateOrder", description = "预支付(创建支付单)", groups = "msfCreatePay")
    public void msfCreatePay() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.create_pay"));
        list.add(new BasicNameValuePair("channel", SqlDetail.getParamValue(0, "channel")));
        list.add(new BasicNameValuePair("subject", "商品描述dayan哈哈"));
        list.add(new BasicNameValuePair("totalAmount", SqlDetail.getParamValue(0, "totalAmount")));
        list.add(new BasicNameValuePair("orderNo", TradecenterConfig.msfCreateOrderOrderNo));
        list.add(new BasicNameValuePair("currency", SqlDetail.getParamValue(0, "msfCurrency")));
        list.add(new BasicNameValuePair("payTypeCode", SqlDetail.getParamValue(0, "payTypeCode")));
        list.add(new BasicNameValuePair("payDesc", SqlDetail.getParamValue(0, "payDesc")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreatePayData.class);
            TradecenterConfig.msfCreatePayTradeNo = model.trade_no;
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(TradecenterConfig.msfCreateOrderOrderNo, "order_no", model.order_no);
        detailAssertTest("trade_no", model.trade_no);
        detailAssertTest("", "sign_data", model.sign_data);
        detailAssertTest("", "reverse", model.reverse);

    }
}
