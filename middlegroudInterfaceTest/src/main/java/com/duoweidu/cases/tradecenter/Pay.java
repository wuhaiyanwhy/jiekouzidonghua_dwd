package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.PayData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Pay extends TradeCenterInterfaceTest {

    private PayData model;

    @Test(dependsOnGroups = "msfCreatePay", description = "支付")
    public void msfPay() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.pay"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreatePayTradeNo));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.msfAccountNumber));
        process(list, true , false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(PayData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(TradecenterConfig.msfCreatePayTradeNo, "trade_no", model.trade_no);
        detailAssertTest(SqlTradecenter.getParamValue(0, "totalAmount"), "pay_amount", String.valueOf(model.pay_amount));
        detailAssertTest(3, "pay_status", model.pay_status);
        detailAssertTest(SqlTradecenter.getParamValue(0, "msfCurrency"), "currency", String.valueOf(model.currency));
        detailAssertTest(SqlTradecenter.getParamValue(0, "payTypeCode"), "pay_type_code", String.valueOf(model.pay_type_code));
        detailAssertTest(SqlTradecenter.getParamValue(0, "payDesc"), "pay_type_desc", String.valueOf(model.pay_type_desc));
        detailAssertTest("", "reverse", model.reverse);
    }
}
