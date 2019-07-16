package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.InterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.ResultData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Cancel extends InterfaceTest {


    {
        url = ConfigFileUrl.getUrlByKey("gateway.http.uri");
        pathId = SqlDetail.getInstance().getPathId("gateway.http.uri");
    }

    private ResultData model;

    @Test(dependsOnGroups = "iqgFreeze", description = "注销账户")
    public void iqgCancel() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.cancel"));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.iqgAccountNumber));
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlDetail.getInstance().getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlDetail.getInstance().getParamValue(0, "createUserId")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getInstance().getParamValue(0, "iqgAppId")));
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
