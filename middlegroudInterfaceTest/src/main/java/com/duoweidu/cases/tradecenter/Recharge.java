package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.RechargeData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Recharge extends TradeCenterInterfaceTest {

    private RechargeData model;

    @Test(dependsOnGroups = "createRecharge", description = "执行充值")
    public void msfRecharge() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.recharge"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreateRechargeTradeNo));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(RechargeData.class);
            msfDetailAssert();
        }
    }

    @Test(dependsOnGroups = "createRecharge", description = "执行充值")
    public void iqgRecharge() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.recharge"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.iqgCreateRechargeTradeNo));

        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(RechargeData.class);
            iqgDetailAssert();
        }
    }

    private void msfDetailAssert() {

        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "rechargeAmount"), "recharge_amount", String.valueOf(model.recharge_amount));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfCurrency"), "currency", model.currency);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "rechargeTypeCode"), "recharge_type_code", model.recharge_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "rechargeDesc"), "recharge_desc", model.recharge_desc);
        detailAssertTest("", "reverse", model.reverse);

    }
    private void iqgDetailAssert() {

        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "rechargeAmount"), "recharge_amount", String.valueOf(model.recharge_amount));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "currency", model.currency);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "rechargeTypeCode"), "recharge_type_code", model.recharge_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "rechargeDesc"), "recharge_desc", model.recharge_desc);
        detailAssertTest("", "reverse", model.reverse);

    }
}
