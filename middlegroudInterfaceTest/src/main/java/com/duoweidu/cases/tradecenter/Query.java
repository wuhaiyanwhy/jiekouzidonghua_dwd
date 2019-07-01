package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
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
    public void msf() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.query"));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.msfAccountNumber));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(416, "account_id", model.account_id);
        detailAssertTest("0130d87d736ea9d126493c036e1a37340828ff5eb440bb56", "account_number", model.account_number);
//        detailAssertTest(388, "available_amount", model.available_amount);
//        detailAssertTest(0, "frozen_amount", model.frozen_amount);
        detailAssertTest(1, "account_status", model.account_status);
        detailAssertTest(1559731193, "created_at", model.created_at);
        detailAssertTest("DWD_MSF_HONEY", "account_type_code", model.account_type_code);
        detailAssertTest("觅食蜂蜂蜜", "account_type_desc", model.account_type_desc);
        detailAssertTest("DWD_MSF_HONEY", "currency", model.currency);
        detailAssertTest("", "reverse", model.reverse);
    }
}
