package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.QueryPayData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class QueryPay extends TradeCenterInterfaceTest {

    private QueryPayData model;

    @Test(dependsOnGroups = "msfCreatePay", description = "查询支付单")
    public void msfQueryPay() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.query_pay"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreatePayTradeNo));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(QueryPayData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(false, "has_refund", model.has_refund);
        detailAssertTest(3, "status", model.status);
        detailAssertTest(SqlTradecenter.getParamValue(0, "totalAmount"), "total_amount", String.valueOf(model.total_amount));
        detailAssertTest(SqlTradecenter.getParamValue(0, "payTypeCode"), "pay_type_code", model.pay_type_code);
        detailAssertTest(SqlTradecenter.getParamValue(0, "payDesc"), "pay_desc", model.pay_desc);
        detailAssertTest("origin_data", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.msfCreatePayTradeNo, "origin_data.trade_no", model.origin_data.trade_no);
        detailAssertTest(TradecenterConfig.msfCreateOrderOrderNo, "origin_data.order_no", model.origin_data.order_no);
        detailAssertTest(SqlTradecenter.getParamValue(0, "totalAmount"), "origin_data.pay_amount", String.valueOf(model.origin_data.pay_amount));
        detailAssertTest(SqlTradecenter.getParamValue(0, "msfCurrency"), "origin_data.currency", model.origin_data.currency);
        detailAssertTest(SqlTradecenter.getParamValue(0, "channelName"), "origin_data.channel_name", model.origin_data.channel_name);
        detailAssertTest(SqlTradecenter.getParamValue(0, "channel"), "origin_data.channel_code", model.origin_data.channel_code);
        detailAssertTest(TradecenterConfig.msfAccountNumber, "origin_data.account_number", model.origin_data.account_number);
        detailAssertTest(3, "origin_data.pay_status", model.origin_data.pay_status);
        detailAssertTest(1, "origin_data.pay_finished", model.origin_data.pay_finished);
        detailAssertTest("origin_data.created_at", model.origin_data.created_at);
        detailAssertTest("origin_data.updated_at", model.origin_data.updated_at);
        detailAssertTest("", "reverse", model.reverse);

    }
}
