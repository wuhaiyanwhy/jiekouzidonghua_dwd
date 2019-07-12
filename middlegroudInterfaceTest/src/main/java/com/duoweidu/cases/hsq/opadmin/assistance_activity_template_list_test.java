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

public class assistance_activity_template_list_test {

    //用来储存参数信息
    private String param;
    //用来储存返回结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "助力免单分享模板列表")
    public void assistance_activity_template_list_true() throws IOException {

        System.out.println(TestConfigOpadmin.assistance_activity_template_list);
        List<NameValuePair> list = new LinkedList<>();

        String results = getJsonResult(list);

        JSONObject jsonObject = new JSONObject(results);
        JSONArray aaData = (JSONArray) jsonObject.get("aaData");

        GeneralAssert.aaDataTest(aaData,TestConfigOpadmin.assistance_activity_template_list,param,result);


    }

    private String getJsonResult(List<NameValuePair>  list) throws IOException {

        HttpPost post = new HttpPost(TestConfigOpadmin.assistance_activity_template_list + "?assistanceChannel=1" +
                "&sEcho=1&iColumns=4&sColumns=%2C%2C%2C&iDisplayStart=0&iDisplayLength=10&mDataProp_0=id" +
                "&mDataProp_1=title&mDataProp_2=status&mDataProp_3=status&_=1534754527647");
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
        post.setEntity(entity);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(post);

        GeneralAssert.codeTest(response,TestConfigOpadmin.assistance_activity_template_list,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.assistance_activity_template_list,param,result);

        return result;
    }
}
