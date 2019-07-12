package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;


public class withdraw_expenditure_list_test {

    //用来储存返回结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "商户支出明细列表")
    public void withdraw_expenditure_list_true() throws IOException {

        System.out.println(TestConfigOpadmin.withdraw_expenditure_list);
        JSONObject param = new JSONObject();
        param.put("createStartTime","2019-01-01");
        param.put("createEndTime","2019-01-15");
        param.put("updateStartTime","null");
        param.put("updateEndTime","null");
        param.put("endStatus","0");
        param.put("type","0");

        String results = getJsonResult(param);

        JSONObject jsonObject = new JSONObject(results);
        JSONArray listJson = (JSONArray) jsonObject.get("list");
        GeneralAssert.listTest(listJson,TestConfigOpadmin.withdraw_expenditure_list,param.toString(),result);


    }

    private String getJsonResult(JSONObject  param) throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.withdraw_expenditure_list);
//        StringEntity entity = new StringEntity(param.toString(),"utf-8");
//        post.setEntity(entity);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigOpadmin.withdraw_expenditure_list, param.toString());

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.withdraw_expenditure_list,param.toString(),result);

        return result;


    }
}
