package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
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
        detailAssertTest(100, "recharge_amount", model.recharge_amount);
        detailAssertTest("DWD_MSF_HONEY", "currency", model.currency);
        detailAssertTest(3, "recharge_status", model.recharge_status);
        detailAssertTest("0130d87d736ea9d126493c036e1a37340828ff5eb440bb56", "account_number", model.account_number);
        detailAssertTest("DAILY_BONUS_dayan", "recharge_type_code", model.recharge_type_code);
        detailAssertTest("觅食蜂充值", "recharge_desc", model.recharge_desc);
        detailAssertTest("recharge_amount", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.msfCreateRechargeTradeNo, "origin_data.trade_no", model.origin_data.trade_no);
        detailAssertTest(100, "origin_data.recharge_amount", model.origin_data.recharge_amount);
        detailAssertTest("DWD_MSF_HONEY", "origin_data.currency", model.origin_data.currency);
        detailAssertTest("多维度Server支付", "origin_data.channel_name", model.origin_data.channel_name);
        detailAssertTest("Dwdpay/DwdpayServer", "origin_data.channel_code", model.origin_data.channel_code);
        detailAssertTest("0130d87d736ea9d126493c036e1a37340828ff5eb440bb56", "origin_data.account_number", model.origin_data.account_number);
        detailAssertTest("origin_data.created_at", model.origin_data.created_at);
        detailAssertTest("origin_data.updated_at", model.origin_data.updated_at);

    }
}
