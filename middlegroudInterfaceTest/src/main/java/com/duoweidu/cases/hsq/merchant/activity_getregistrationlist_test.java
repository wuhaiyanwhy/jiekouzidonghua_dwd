package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigMerchant;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class activity_getregistrationlist_test {

    //用来储存返回结果
    private String result;

    @Test(groups = "loginTrue",description = "报名营销活动列表")
    public void activity_getregistrationlist_true() throws IOException {
        System.out.println(TestConfigMerchant.activity_getregistrationlist);
        String results = getJsonResult();
    }

    private String getJsonResult() throws IOException {
        HttpGet get = new HttpGet(TestConfigMerchant.activity_getregistrationlist);
        TestConfigMerchant.defaultHttpClient.setCookieStore(TestConfigMerchant.store);
        HttpResponse response = TestConfigMerchant.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigMerchant.activity_getregistrationlist,null);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigMerchant.activity_getregistrationlist,null,result);
        return result;
    }
}
