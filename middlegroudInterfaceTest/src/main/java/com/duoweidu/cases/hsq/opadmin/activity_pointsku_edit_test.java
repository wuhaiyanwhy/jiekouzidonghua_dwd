package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class activity_pointsku_edit_test {

    //用来储存参数信息
    private String param;
    //用来储存返回结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "支付宝活动管理")
    public void activity_pointsku_edit_true() throws IOException {

        System.out.println(TestConfigOpadmin.activity_pointsku_edit);

        String results = getJsonResult();


    }

    private String getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.activity_pointsku_edit);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigOpadmin.activity_pointsku_edit,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.activity_pointsku_edit,param,result);
        return result;
    }
}
