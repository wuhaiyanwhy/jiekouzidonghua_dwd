package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.CreateData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Query extends TradeCenterInterfaceTest {

    private CreateData model;

    @Test(dependsOnGroups = "msfCreate", description = "查询账户信息")
    public void msfQuery() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.query"));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.msfAccountNumber));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateData.class);
            detailAssert("msf");
        }
    }

    @Test(dependsOnGroups = "iqgCreate", description = "查询账户信息")
    public void iqgQuery() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.query"));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.iqgAccountNumber));

        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateData.class);
            detailAssert("iqg");
        }
    }

    private void detailAssert(String platformCode) {

        if (platformCode.equals("iqg")) {
            detailAssertTest(417, "account_id", model.account_id);
            detailAssertTest(TradecenterConfig.iqgAccountNumber, "account_number", model.account_number);
            detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "account_type_code", model.account_type_code);
            detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgAccountTypeDesc"), "account_type_desc", model.account_type_desc);
            detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "currency", model.currency);

        }else{
            detailAssertTest(416, "account_id", model.account_id);
            detailAssertTest(TradecenterConfig.msfAccountNumber, "account_number", model.account_number);
            detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfCurrency"), "account_type_code", model.account_type_code);
            detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfAccountTypeDesc"), "account_type_desc", model.account_type_desc);
            detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfCurrency"), "currency", model.currency);
        }
        detailAssertTest("available_amount", model.available_amount);
        detailAssertTest("frozen_amount", String.valueOf(model.frozen_amount));
        detailAssertTest(1, "account_status", model.account_status);
        detailAssertTest(1559731193, "created_at", model.created_at);
        detailAssertTest("", "reverse", model.reverse);
    }
}
