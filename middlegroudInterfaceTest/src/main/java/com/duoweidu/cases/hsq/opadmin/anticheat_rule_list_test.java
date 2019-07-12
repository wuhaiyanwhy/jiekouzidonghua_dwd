package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class anticheat_rule_list_test {


    //用来储存参数信息
    private String param;
    //用来储存返回的结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "反作弊管理列表")
    public void anticheat_rule_list_true() throws IOException {
        System.out.println(TestConfigOpadmin.anticheat_rule_list);
        List<NameValuePair> list = new LinkedList<>();

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");

        String results = getJsonResult(entity);

        JSONObject jsonObject = new JSONObject(results);
        JSONArray aaData = (JSONArray) jsonObject.get("aaData");

        GeneralAssert.aaDataTest(aaData,TestConfigOpadmin.anticheat_rule_list,param,result);


    }


    private String getJsonResult(UrlEncodedFormEntity entity) throws IOException {

        HttpPost post = new HttpPost(TestConfigOpadmin.anticheat_rule_list);
        post.setEntity(entity);

        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);

        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(post);
        GeneralAssert.codeTest(response,TestConfigOpadmin.anticheat_rule_list,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.anticheat_rule_list,param,result);

        return result;
    }
}
