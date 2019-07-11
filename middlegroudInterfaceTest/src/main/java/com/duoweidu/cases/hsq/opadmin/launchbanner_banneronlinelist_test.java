package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class launchbanner_banneronlinelist_test {

    //用来储存参数信息
    private String param;
    //用来储存返回结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "启动页列表")
    public void launchbanner_banneronlinelist_true() throws IOException {

        System.out.println(TestConfigOpadmin.launchbanner_banneronlinelist);

        String results = getJsonResult();

        JSONObject jsonObject = new JSONObject(results);
//        JSONArray aaData = (JSONArray) jsonObject.get("aaData");
//        GeneralAssert.aaDataTest(aaData,TestConfigOpadmin.launchbanner_banneronlinelist,param,result);

    }

    private String getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.launchbanner_banneronlinelist);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigOpadmin.launchbanner_banneronlinelist,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.launchbanner_banneronlinelist,param,result);
        return result;
    }
}
