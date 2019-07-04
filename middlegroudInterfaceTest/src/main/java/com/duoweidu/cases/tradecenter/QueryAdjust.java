package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlDetail;
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
        detailAssertTest(SqlDetail.getParamValue(0, "msfCurrency"), "currency", model.currency);
        detailAssertTest(TradecenterConfig.msfAccountNumber, "account_number", model.account_number);
        detailAssertTest("created_at", model.created_at);
        detailAssertTest(TradecenterConfig.msfCreateAdjustTradeNo, "trade_no", model.trade_no);
        detailAssertTest(SqlDetail.getParamValue(0, "adjustTypeCode"), "adjust_type_code", model.adjust_type_code);
        detailAssertTest(SqlDetail.getParamValue(0, "adjustDesc"), "adjust_desc", model.adjust_desc);
        detailAssertTest("origin_data", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.msfCreateAdjustTradeNo, "origin_data.trade_no", model.origin_data.trade_no);
        detailAssertTest(TradecenterConfig.msfAccountNumber, "origin_data.account_number", model.origin_data.account_number);
        detailAssertTest(SqlDetail.getParamValue(0, "adjustAmount"), "origin_data.adjust_amount", String.valueOf(model.origin_data.adjust_amount));
        detailAssertTest(3, "origin_data.adjust_status", model.origin_data.adjust_status);
        detailAssertTest(SqlDetail.getParamValue(0, "msfCurrency"), "origin_data.currency", model.origin_data.currency);
        detailAssertTest("origin_data.created_at", model.origin_data.created_at);
        detailAssertTest("origin_data.updated_at", model.origin_data.updated_at);

    }
}
