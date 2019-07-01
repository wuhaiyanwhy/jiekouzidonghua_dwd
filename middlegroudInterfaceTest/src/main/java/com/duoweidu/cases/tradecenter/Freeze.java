package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.InterfaceTest;
import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.ResultData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Freeze extends InterfaceTest {

    {
        url = ConfigFileUrl.getUrlByKey("gatewayHttp");
        pathId = SqlTradecenter.getPathId("gatewayHttp");
    }

    private ResultData model;

    @Test(dependsOnGroups = "iqgActivate", description = "冻结账户", groups = "iqgFreeze")
    public void iqgFreeze() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.freeze"));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.iqgAccountNumber));
        list.add(new BasicNameValuePair("version", SqlTradecenter.getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlTradecenter.getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlTradecenter.getParamValue(0, "createUserId")));
        list.add(new BasicNameValuePair("appId", SqlTradecenter.getParamValue(0, "iqgAppId")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(ResultData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest("success", "result", model.result);
        detailAssertTest("", "reverse", model.reverse);
    }
}
