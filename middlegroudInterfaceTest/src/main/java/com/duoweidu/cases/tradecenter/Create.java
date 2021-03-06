package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.InterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
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
        url = ConfigFileUrl.getUrlByKey("gateway.http.uri");
        pathId = SqlDetail.getInstance().getPathId("gateway.http.uri");
    }

    private CreateData model;

    /**
     * 这是已创建过得用户
     */
    @Test(groups = "msfCreate", description = "创建觅食蜂账户")
    public void msfCreate() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.create"));
        list.add(new BasicNameValuePair("accountTypeCode", SqlDetail.getInstance().getParamValue(0, "msfCurrency")));
        list.add(new BasicNameValuePair("availableAmount", "0"));
        list.add(new BasicNameValuePair("frozenAmount", "0"));
        list.add(new BasicNameValuePair("accountStatus", "2"));
        list.add(new BasicNameValuePair("multi", "0"));
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlDetail.getInstance().getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlDetail.getInstance().getParamValue(0, "userId")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getInstance().getParamValue(0, "msfAppId")));
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
    @Test(groups = "iqgNewCreate", description = "创建爱抢购账户")
    public void iqgNewCreate() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.create"));
        list.add(new BasicNameValuePair("accountTypeCode", SqlDetail.getInstance().getParamValue(0, "iqgCurrency")));
        list.add(new BasicNameValuePair("availableAmount", "0"));
        list.add(new BasicNameValuePair("frozenAmount", "0"));
        list.add(new BasicNameValuePair("accountStatus", "2"));
        list.add(new BasicNameValuePair("multi", "0"));
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlDetail.getInstance().getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlDetail.getInstance().getParamValue(0, "createUserId")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getInstance().getParamValue(0, "iqgAppId")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateData.class);
            TradecenterConfig.iqgNewAccountNumber = model.account_number;
            System.out.println(TradecenterConfig.iqgAccountNumber);
            iqgNewDetailAssert();
        }
    }

    /**
     * 这是已创建的用户
     */
    @Test(groups = "iqgCreate", description = "创建爱抢购账户")
    public void iqgCreate() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.create"));
        list.add(new BasicNameValuePair("accountTypeCode", SqlDetail.getInstance().getParamValue(0, "iqgCurrency")));
        list.add(new BasicNameValuePair("availableAmount", "0"));
        list.add(new BasicNameValuePair("frozenAmount", "0"));
        list.add(new BasicNameValuePair("accountStatus", "2"));
        list.add(new BasicNameValuePair("multi", "0"));
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlDetail.getInstance().getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlDetail.getInstance().getParamValue(0, "userId")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getInstance().getParamValue(0, "iqgAppId")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateData.class);
            TradecenterConfig.iqgAccountNumber = model.account_number;
            System.out.println(TradecenterConfig.iqgAccountNumber);
            iqgDetailAssert();
        }
    }

    /**
     * 这是已创建的用户
     */
    @Test(groups = "jszCreate", description = "创建巨食阵账户")
    public void jszCreate() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.create"));
        list.add(new BasicNameValuePair("accountTypeCode", SqlDetail.getInstance().getParamValue(0, "jszCurrency")));
        list.add(new BasicNameValuePair("availableAmount", "0"));
        list.add(new BasicNameValuePair("frozenAmount", "0"));
        list.add(new BasicNameValuePair("accountStatus", "2"));
        list.add(new BasicNameValuePair("multi", "0"));
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlDetail.getInstance().getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlDetail.getInstance().getParamValue(0, "userId")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getInstance().getParamValue(0, "jszAppId")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateData.class);
            TradecenterConfig.jszAccountNumber = model.account_number;
            System.out.println(TradecenterConfig.iqgAccountNumber);
            jszDetailAssert();
        }
    }

    private void msfDetailAssert() {
        detailAssertTest(416, "account_id", model.account_id);
        detailAssertTest(TradecenterConfig.msfAccountNumber, "account_number", model.account_number);
        detailAssertTest("available_amount", String.valueOf(model.available_amount));
        detailAssertTest("frozen_amount", String.valueOf(model.frozen_amount));
        detailAssertTest(1, "account_status", model.account_status);
        detailAssertTest(1559731193, "created_at", model.created_at);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfCurrency"), "account_type_code", model.account_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfAccountTypeDesc"), "account_type_desc", model.account_type_desc);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfCurrency"), "currency", model.currency);
        detailAssertTest("", "reverse", model.reverse);
    }

    private void iqgNewDetailAssert() {
        detailAssertTest("account_id", model.account_id);
        detailAssertTest("account_number", model.account_number);
        detailAssertTest(0, "available_amount", model.available_amount);
        detailAssertTest(0, "frozen_amount", model.frozen_amount);
        detailAssertTest("account_status", model.account_status);
        detailAssertTest("created_at", model.created_at);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "account_type_code", model.account_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgAccountTypeDesc"), "account_type_desc", model.account_type_desc);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "currency", model.currency);
        detailAssertTest("", "reverse", model.reverse);
    }

    private void iqgDetailAssert() {
        detailAssertTest(417,"account_id", model.account_id);
        detailAssertTest(TradecenterConfig.iqgAccountNumber,"account_number", model.account_number);
        detailAssertTest("available_amount", String.valueOf(model.available_amount));
        detailAssertTest("frozen_amount", String.valueOf(model.frozen_amount));
        detailAssertTest(1,"account_status", model.account_status);
        detailAssertTest(1559731193,"created_at", model.created_at);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "account_type_code", model.account_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgAccountTypeDesc"), "account_type_desc", model.account_type_desc);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "currency", model.currency);
        detailAssertTest("", "reverse", model.reverse);
    }

    private void jszDetailAssert() {
        detailAssertTest(605, "account_id", model.account_id);
        detailAssertTest(TradecenterConfig.jszAccountNumber, "account_number", model.account_number);
        detailAssertTest("available_amount", String.valueOf(model.available_amount));
        detailAssertTest("frozen_amount", String.valueOf(model.frozen_amount));
        detailAssertTest(1, "account_status", model.account_status);
        detailAssertTest(1565057766, "created_at", model.created_at);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "jszCurrency"), "account_type_code", model.account_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "jszAccountTypeDesc"), "account_type_desc", model.account_type_desc);
        detailAssertTest("CNY","currency", model.currency);
        detailAssertTest("", "reverse", model.reverse);
    }
}
