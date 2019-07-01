package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.InterfaceTest;
import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.CreateData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Create extends InterfaceTest {

    {
        url = ConfigFileUrl.getUrlByKey("gatewayHttp");
        pathId = SqlTradecenter.getPathId("gatewayHttp");
    }

    private CreateData model;

    /**
     * 这是已创建过得用户
     */
    @Test(groups = "msfCreate", description = "创建觅食蜂账户")
    public void msf() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.create"));
        list.add(new BasicNameValuePair("accountTypeCode", "DWD_MSF_HONEY"));
        list.add(new BasicNameValuePair("availableAmount", "0"));
        list.add(new BasicNameValuePair("frozenAmount", "0"));
        list.add(new BasicNameValuePair("accountStatus", "2"));
        list.add(new BasicNameValuePair("multi", "0"));
        list.add(new BasicNameValuePair("version", SqlTradecenter.getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlTradecenter.getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlTradecenter.getParamValue(0, "userId")));
        list.add(new BasicNameValuePair("appId", SqlTradecenter.getParamValue(0, "msfAppId")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateData.class);
            TradecenterConfig.msfAccountNumber = model.account_number;
            msfDetailAssert();
        }

    }

    /**
     * 这是新创建的用户
     */
    @Test(groups = "iqgCreate", description = "创建爱抢购账户")
    public void iqg() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.create"));
        list.add(new BasicNameValuePair("accountTypeCode", "DWD_IQG_COIN"));
        list.add(new BasicNameValuePair("availableAmount", "0"));
        list.add(new BasicNameValuePair("frozenAmount", "0"));
        list.add(new BasicNameValuePair("accountStatus", "2"));
        list.add(new BasicNameValuePair("multi", "0"));
        list.add(new BasicNameValuePair("version", SqlTradecenter.getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlTradecenter.getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlTradecenter.getParamValue(0, "createUserId")));
        list.add(new BasicNameValuePair("appId", SqlTradecenter.getParamValue(0, "iqgAppId")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateData.class);
            TradecenterConfig.iqgAccountNumber = model.account_number;
            System.out.println(TradecenterConfig.iqgAccountNumber);
            iqgDetailAssert();
        }
    }

    private void msfDetailAssert() {
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

    private void iqgDetailAssert() {
//        detailAssertTest(477, "account_id", model.account_id);
//        detailAssertTest("5f3f38eb6fa035bb941efe8e621d2cefd3c1b177abc76d32", "account_number", model.account_number);
        detailAssertTest(0, "available_amount", model.available_amount);
        detailAssertTest(0, "frozen_amount", model.frozen_amount);
//        detailAssertTest(2, "account_status", model.account_status);
//        detailAssertTest(1561709445, "created_at", model.created_at);
//        detailAssertTest(1561709445, "updated_at", model.updated_at);
        detailAssertTest("DWD_IQG_COIN", "account_type_code", model.account_type_code);
        detailAssertTest("爱抢购金币", "account_type_desc", model.account_type_desc);
        detailAssertTest("DWD_IQG_COIN", "currency", model.currency);
        detailAssertTest("", "reverse", model.reverse);
    }
}
