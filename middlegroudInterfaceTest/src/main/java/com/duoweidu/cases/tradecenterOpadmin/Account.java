package com.duoweidu.cases.tradecenterOpadmin;

import com.duoweidu.cases.interfaces.TradeCenterOpadminInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.tradecenteropadmin.AccountData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Account extends TradeCenterOpadminInterfaceTest {

    private AccountData model;

    @Test(description = "账户信息查询")
    public void account() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "get account.account"));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(AccountData.class);
            detailAssert();
        }
    }

    private void detailAssert() {

        detailAssertTest(SqlDetail.getParamValue(0, "accountNumber"), "account_number", model.account_number);
        detailAssertTest("available_amount", model.available_amount);
        detailAssertTest("frozen_amount", String.valueOf(model.frozen_amount));
        detailAssertTest("created_at", model.created_at);
        detailAssertTest("激活", "account_status", model.account_status);
        detailAssertTest("蜂蜜", "account_type_name", model.account_type_name);
        detailAssertTest(SqlDetail.getParamValue(0, "msfCurrency"), "account_type_code", model.account_type_code);
        detailAssertTest(SqlDetail.getParamValue(0, "msfCurrency"), "currency", model.currency);
        detailAssertTest(1, "platform_id", model.platform_id);
        detailAssertTest("觅食蜂", "platform_name", model.platform_name);


    }
}
