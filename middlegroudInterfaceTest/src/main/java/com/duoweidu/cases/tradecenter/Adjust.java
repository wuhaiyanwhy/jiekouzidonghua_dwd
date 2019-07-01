package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
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
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(TradecenterConfig.msfCreateAdjustTradeNo, "trade_no", model.trade_no);
        detailAssertTest("0130d87d736ea9d126493c036e1a37340828ff5eb440bb56", "account_number", model.account_number);
        detailAssertTest(-2, "adjust_amount", model.adjust_amount);
        detailAssertTest("DWD_MSF_HONEY", "currency", model.currency);
        detailAssertTest("DELETE_ARTICLE", "adjust_type_code", model.adjust_type_code);
        detailAssertTest("觅食蜂调账", "adjust_desc", model.adjust_desc);
        detailAssertTest("", "reverse", model.reverse);

    }
}
