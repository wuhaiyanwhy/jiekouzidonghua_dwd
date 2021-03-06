package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.AdjustData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Adjust extends TradeCenterInterfaceTest {

    private AdjustData model;

    @Test(dependsOnGroups = "msfCreateAdjust", description = "执行调账")
    public void msfAdjust() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.adjust"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreateAdjustTradeNo));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(AdjustData.class);
            msfDetailAssert();
        }
    }

    @Test(dependsOnGroups = "iqgCreateAdjust", description = "执行调账")
    public void iqgAdjust() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.adjust"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.iqgCreateAdjustTradeNo));

        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(AdjustData.class);
            iqgDetailAssert();
        }
    }

    private void msfDetailAssert() {
        detailAssertTest(TradecenterConfig.msfCreateAdjustTradeNo, "trade_no", model.trade_no);
        detailAssertTest(TradecenterConfig.msfAccountNumber, "account_number", model.account_number);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "adjustAmount"), "adjust_amount", String.valueOf(model.adjust_amount));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfCurrency"), "currency", model.currency);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "adjustTypeCode"), "adjust_type_code", model.adjust_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "adjustDesc"), "adjust_desc", model.adjust_desc);
        detailAssertTest("", "reverse", model.reverse);

    }
    private void iqgDetailAssert() {
        detailAssertTest(TradecenterConfig.iqgCreateAdjustTradeNo, "trade_no", model.trade_no);
        detailAssertTest(TradecenterConfig.iqgAccountNumber, "account_number", model.account_number);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "adjustAmount"), "adjust_amount", String.valueOf(model.adjust_amount));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "currency", model.currency);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "adjustTypeCode"), "adjust_type_code", model.adjust_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "adjustDesc"), "adjust_desc", model.adjust_desc);
        detailAssertTest("", "reverse", model.reverse);

    }
}
