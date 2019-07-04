package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.TradeNoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CreateRefund extends TradeCenterInterfaceTest {

    private TradeNoData model;

    @Test(dependsOnGroups = "msfCreatePay", description = "创建退款单", groups = "msfCreateRefund")
    public void msfCreateRefund() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.create_refund"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreatePayTradeNo));
        list.add(new BasicNameValuePair("refundAmount", SqlDetail.getParamValue(0, "createRefundAmount")));
        list.add(new BasicNameValuePair("refundTypeCode", SqlDetail.getParamValue(0, "refundTypeCode")));
        list.add(new BasicNameValuePair("refundDesc", SqlDetail.getParamValue(0, "refundDesc")));
        list.add(new BasicNameValuePair("orderNo", TradecenterConfig.msfCreateOrderOrderNo));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(TradeNoData.class);
            detailAssert();
            TradecenterConfig.msfCreateRefundTradeNo = model.trade_no;
        }
    }

    private void detailAssert() {
        detailAssertTest("trade_no", model.trade_no);
    }
}
