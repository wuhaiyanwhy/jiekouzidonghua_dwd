package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.QueryRechargeData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class QueryRecharge extends TradeCenterInterfaceTest {

    private QueryRechargeData model;

    @Test(dependsOnGroups = "createRecharge", description = "查询充值单")
    public void msfQueryRecharge() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.query_recharge"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreateRechargeTradeNo));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(QueryRechargeData.class);
            detailAssert();
        }

    }

    private void detailAssert() {

        detailAssertTest(TradecenterConfig.msfCreateRechargeTradeNo, "trade_no", model.trade_no);
        detailAssertTest(SqlDetail.getParamValue(0, "rechargeAmount"), "recharge_amount", String.valueOf(model.recharge_amount));
        detailAssertTest(SqlDetail.getParamValue(0, "msfCurrency"), "currency", model.currency);
        detailAssertTest(3, "recharge_status", model.recharge_status);
        detailAssertTest(TradecenterConfig.msfAccountNumber, "account_number", model.account_number);
        detailAssertTest(SqlDetail.getParamValue(0, "rechargeTypeCode"), "recharge_type_code", model.recharge_type_code);
        detailAssertTest(SqlDetail.getParamValue(0, "rechargeDesc"), "recharge_desc", model.recharge_desc);
        detailAssertTest("recharge_amount", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.msfCreateRechargeTradeNo, "origin_data.trade_no", model.origin_data.trade_no);
        detailAssertTest(SqlDetail.getParamValue(0, "rechargeAmount"), "origin_data.recharge_amount", String.valueOf(model.origin_data.recharge_amount));
        detailAssertTest(SqlDetail.getParamValue(0, "msfCurrency"), "origin_data.currency", model.origin_data.currency);
        detailAssertTest(SqlDetail.getParamValue(0, "channelName"), "origin_data.channel_name", model.origin_data.channel_name);
        detailAssertTest(SqlDetail.getParamValue(0, "channel"), "origin_data.channel_code", model.origin_data.channel_code);
        detailAssertTest(TradecenterConfig.msfAccountNumber, "origin_data.account_number", model.origin_data.account_number);
        detailAssertTest("origin_data.created_at", model.origin_data.created_at);
        detailAssertTest("origin_data.updated_at", model.origin_data.updated_at);

    }
}
