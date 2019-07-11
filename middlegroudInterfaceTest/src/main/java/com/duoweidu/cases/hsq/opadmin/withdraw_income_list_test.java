package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class withdraw_income_list_test {

    //用来储存返回结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "对账明细列表")
    public void withdraw_income_list_true() throws IOException {

        System.out.println(TestConfigOpadmin.withdraw_income_list);

        JSONObject param = new JSONObject();
        param.put("confirmStartTime","2019-01-01");
        param.put("confirmEndTime","2019-01-15");
        param.put("merchantName","");
        param.put("orderNo","");

        String results = getJsonResult(param);

        JSONObject jsonObject = new JSONObject(results);
        JSONObject data = (JSONObject) jsonObject.get("data");
        GeneralAssert.dataTest(data.toString(),TestConfigOpadmin.withdraw_income_list,param.toString(),result);
        JSONArray listJson = (JSONArray) data.get("list");
        GeneralAssert.listTest(listJson,TestConfigOpadmin.withdraw_income_list,param.toString(),result);


    }

    private String getJsonResult(JSONObject  param) throws IOException {

        HttpPost post = new HttpPost(TestConfigOpadmin.withdraw_income_list);
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(post);

        GeneralAssert.codeTest(response,TestConfigOpadmin.withdraw_income_list,param.toString());

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.withdraw_income_list,param.toString(),result);

        return result;
    }
}
