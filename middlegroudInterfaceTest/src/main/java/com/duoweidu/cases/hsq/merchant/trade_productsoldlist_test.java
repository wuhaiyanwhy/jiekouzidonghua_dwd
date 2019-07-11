package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigMerchant;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class trade_productsoldlist_test {

    //用来储存返回结果
    private String result;

    @Test(groups = "loginTrue",description = "已卖出的宝贝")
    public void trade_productsoldlist_true() throws IOException {
        System.out.println(TestConfigMerchant.trade_productsoldlist);
        String results = getJsonResult();
    }

    private String getJsonResult() throws IOException {
        HttpGet get = new HttpGet(TestConfigMerchant.trade_productsoldlist);
        TestConfigMerchant.defaultHttpClient.setCookieStore(TestConfigMerchant.store);
        HttpResponse response = TestConfigMerchant.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigMerchant.trade_productsoldlist,null);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigMerchant.trade_productsoldlist,null,result);
        return result;
    }
}
