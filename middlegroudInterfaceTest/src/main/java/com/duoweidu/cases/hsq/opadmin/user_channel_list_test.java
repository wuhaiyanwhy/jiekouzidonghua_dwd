package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_channel_list_test {


    //用来储存参数信息
    private String param;
    //用来储存返回的结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "渠道信息列表")
    public void user_channel_list_true() throws IOException {
        System.out.println(TestConfigOpadmin.user_channel_list);
        List<NameValuePair> list = new LinkedList<>();

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");


        JSONObject results = getJsonResult(entity);





    }


    private JSONObject getJsonResult(UrlEncodedFormEntity entity) throws IOException {

        HttpPost post = new HttpPost(TestConfigOpadmin.user_channel_list);
        post.setEntity(entity);

        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);

        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(post);
        System.out.println(TestConfigOpadmin.defaultHttpClient.getCookieStore());

        GeneralAssert.codeTest(response,TestConfigOpadmin.user_channel_list,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.user_channel_list,param,result);
        System.out.println("返回的头信息：" + response.getLocale());
        System.out.println(TestConfigOpadmin.store);

        JSONObject jsonObject = new JSONObject(result);
        return jsonObject;
    }


}
