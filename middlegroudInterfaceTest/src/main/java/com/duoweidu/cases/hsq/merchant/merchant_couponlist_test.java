package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigMerchant;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class merchant_couponlist_test {

    //用来储存返回结果
    private String result;

    @Test(groups = "loginTrue",description = "优惠券管理列表")
    public void merchant_couponlist_true() throws IOException {
        System.out.println(TestConfigMerchant.merchant_couponlist);
        String results = getJsonResult();
    }

    private String getJsonResult() throws IOException {
        HttpGet get = new HttpGet(TestConfigMerchant.merchant_couponlist);
        TestConfigMerchant.defaultHttpClient.setCookieStore(TestConfigMerchant.store);
        HttpResponse response = TestConfigMerchant.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigMerchant.merchant_couponlist,null);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigMerchant.merchant_couponlist,null,result);
        return result;
    }
}
