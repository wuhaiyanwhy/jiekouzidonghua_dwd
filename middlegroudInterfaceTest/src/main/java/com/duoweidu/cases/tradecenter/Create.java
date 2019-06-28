package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.InterfaceTest;
import com.duoweidu.config.SqlTradecenter;
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

    @Test(description = "创建觅食蜂账户")
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
        list.add(new BasicNameValuePair("userId", SqlTradecenter.getParamValue(0, "createUserId")));
        list.add(new BasicNameValuePair("appId", SqlTradecenter.getParamValue(0, "msfAppId")));
        process(list, true, false);
        model = sparseJson(CreateData.class);
        msfDetailAssert();


    }

    @Test(description = "创建爱抢购账户")
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
    }

    private void msfDetailAssert() {
        detailAssertTest(416, "account_id", model.account_id);
    }
}
