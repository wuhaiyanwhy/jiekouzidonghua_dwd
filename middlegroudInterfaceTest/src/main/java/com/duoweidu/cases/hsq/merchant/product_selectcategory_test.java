package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigMerchant;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class product_selectcategory_test {

    //用来储存返回结果
    private String result;

    @Test(groups = "loginTrue",description = "发布新商品")
    public void product_selectcategory_true() throws IOException {
        System.out.println(TestConfigMerchant.product_selectcategory);
        String results = getJsonResult();
    }

    private String getJsonResult() throws IOException {
        HttpGet get = new HttpGet(TestConfigMerchant.product_selectcategory);
        TestConfigMerchant.defaultHttpClient.setCookieStore(TestConfigMerchant.store);
        HttpResponse response = TestConfigMerchant.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigMerchant.product_selectcategory,null);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigMerchant.product_selectcategory,null,result);
        return result;
    }
}
