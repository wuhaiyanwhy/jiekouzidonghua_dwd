package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class market_mtcnotifytpl_show_test {

    //用来储存参数信息
    private String param;
    //用来储存返回结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "消息模板管理")
    public void market_mtcnotifytpl_show_true() throws IOException {

        System.out.println(TestConfigOpadmin.market_mtcnotifytpl_show);

        String results = getJsonResult();


    }

    private String getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.market_mtcnotifytpl_show);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigOpadmin.market_mtcnotifytpl_show,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.market_mtcnotifytpl_show,param,result);
        return result;
    }
}
