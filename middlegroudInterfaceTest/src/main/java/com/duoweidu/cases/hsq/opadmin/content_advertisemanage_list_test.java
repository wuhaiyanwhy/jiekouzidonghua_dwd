package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class content_advertisemanage_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "广告位管理列表")
    public void content_advertisemanage_list_true() {

        setUrl("content.advertisemanage.list.uri");
        JSONObject param = new JSONObject();
        param.put("channel","1");
        param.put("status","");
        param.put("title","");
        param.put("startTime","");
        param.put("endTime","");
        param.put("pageNum","1");

        String results = getJsonResult(param);

        JSONObject jsonObject = new JSONObject(results);
        JSONObject data = (JSONObject) jsonObject.get("data");
        GeneralAssert.dataTest(data.toString(),TestConfigOpadmin.content_advertisemanage_list,param.toString(),result);
        JSONArray listJson = (JSONArray) data.get("list");
        GeneralAssert.listTest(listJson,TestConfigOpadmin.content_advertisemanage_list,param.toString(),result);


    }

    private String getJsonResult(JSONObject  param) throws IOException {

        HttpPost post = new HttpPost(TestConfigOpadmin.content_advertisemanage_list);
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(post);

        GeneralAssert.codeTest(response,TestConfigOpadmin.content_advertisemanage_list, param.toString());

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.content_advertisemanage_list,param.toString(),result);

        return result;


    }

}
