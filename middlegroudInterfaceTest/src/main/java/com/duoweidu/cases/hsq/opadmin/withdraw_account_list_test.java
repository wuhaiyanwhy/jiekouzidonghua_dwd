package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class withdraw_account_list_test {

    //用来储存参数信息
    private String param;
    //用来储存返回结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "商家提现列表")
    public void withdraw_account_list_true() throws IOException {

        System.out.println(TestConfigOpadmin.withdraw_account_list);

        String results = getJsonResult();
        JSONObject jsonObject = new JSONObject(results);
        JSONArray listJson = (JSONArray) jsonObject.get("list");
        GeneralAssert.listTest(listJson,TestConfigOpadmin.content_customspeciallist,param,result);


    }

    private String getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.withdraw_account_list);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigOpadmin.withdraw_account_list,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.withdraw_account_list,param,result);
        return result;
    }
}
