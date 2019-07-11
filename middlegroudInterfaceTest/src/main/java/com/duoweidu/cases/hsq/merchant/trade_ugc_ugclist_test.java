package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigMerchant;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class trade_ugc_ugclist_test {

    //用来储存返回结果
    private String result;

    @Test(groups = "loginTrue",description = "评价管理")
    public void trade_ugc_ugclist_true() throws IOException {
        System.out.println(TestConfigMerchant.trade_ugc_ugclist);
        String results = getJsonResult();
    }

    private String getJsonResult() throws IOException {
        HttpGet get = new HttpGet(TestConfigMerchant.trade_ugc_ugclist);
        TestConfigMerchant.defaultHttpClient.setCookieStore(TestConfigMerchant.store);
        HttpResponse response = TestConfigMerchant.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigMerchant.trade_ugc_ugclist,null);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigMerchant.trade_ugc_ugclist,null,result);
        return result;
    }
}
