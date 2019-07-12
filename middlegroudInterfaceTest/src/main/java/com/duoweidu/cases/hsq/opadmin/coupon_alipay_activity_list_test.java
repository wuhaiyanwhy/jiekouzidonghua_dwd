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

public class coupon_alipay_activity_list_test {


    //用来储存参数信息
    private String param;
    //用来储存返回的结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "支付宝领券活动列表")
    public void coupon_alipay_activity_list_true() throws IOException {
        System.out.println(TestConfigOpadmin.coupon_alipay_activity_list);
        List<NameValuePair> list = new LinkedList<>();

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");

        String results = getJsonResult(entity);

        JSONObject jsonObject = new JSONObject(results);
        JSONArray listJson = (JSONArray) jsonObject.get("list");
        GeneralAssert.listTest(listJson,TestConfigOpadmin.coupon_alipay_activity_list,param,result);


    }


    private String getJsonResult(UrlEncodedFormEntity entity) throws IOException {

        HttpPost post = new HttpPost(TestConfigOpadmin.coupon_alipay_activity_list);
        post.setEntity(entity);

        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);

        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(post);
        GeneralAssert.codeTest(response,TestConfigOpadmin.coupon_alipay_activity_list,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.coupon_alipay_activity_list,param,result);

        return result;
    }
}
