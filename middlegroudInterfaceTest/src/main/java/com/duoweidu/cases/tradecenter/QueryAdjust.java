package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.QueryAdjustData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class QueryAdjust extends TradeCenterInterfaceTest {

    private QueryAdjustData model;

    @Test(dependsOnGroups = "msfCreateAdjust", description = "查询调账单")
    public void msfQueryAdjust() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.query_adjust"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreateAdjustTradeNo));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(QueryAdjustData.class);
            detailAssert();
        }

    }

    private void detailAssert() {
        detailAssertTest(3, "status", model.status);
        detailAssertTest(-2, "adjust_amount", model.adjust_amount);
        detailAssertTest("DWD_MSF_HONEY", "currency", model.currency);
        detailAssertTest("0130d87d736ea9d126493c036e1a37340828ff5eb440bb56", "account_number", model.account_number);
        detailAssertTest("created_at", model.created_at);
        detailAssertTest(TradecenterConfig.msfCreateAdjustTradeNo, "trade_no", model.trade_no);
        detailAssertTest("DELETE_ARTICLE", "adjust_type_code", model.adjust_type_code);
        detailAssertTest("觅食蜂调账", "adjust_desc", model.adjust_desc);
        detailAssertTest("origin_data", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.msfCreateAdjustTradeNo, "origin_data.trade_no", model.origin_data.trade_no);
        detailAssertTest("0130d87d736ea9d126493c036e1a37340828ff5eb440bb56", "origin_data.account_number", model.origin_data.account_number);
        detailAssertTest(-2, "origin_data.adjust_amount", model.origin_data.adjust_amount);
        detailAssertTest(3, "origin_data.adjust_status", model.origin_data.adjust_status);
        detailAssertTest("DWD_MSF_HONEY", "origin_data.currency", model.origin_data.currency);
        detailAssertTest("origin_data.created_at", model.origin_data.created_at);
        detailAssertTest("origin_data.updated_at", model.origin_data.updated_at);

    }
}
