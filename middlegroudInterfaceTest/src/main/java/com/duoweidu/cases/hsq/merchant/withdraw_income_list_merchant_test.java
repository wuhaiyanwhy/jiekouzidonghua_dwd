package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigMerchant;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class withdraw_income_list_merchant_test {

    //用来储存参数信息
    private String param;
    //用来储存返回结果
    private String result;

    @Test(groups = "loginTrue",description = "收入明细列表")
    public void withdraw_income_list_merchant_true () throws IOException {
        System.out.println(TestConfigMerchant.withdraw_income_list_merchant);
        String results = getJsonResult();
    }

    private String getJsonResult() throws IOException {
        param = "confirmStartDate=2018-09-01&confirmEndDate=2019-01-31";
        HttpGet get = new HttpGet(TestConfigMerchant.withdraw_income_list_merchant+"?"+param);
        TestConfigMerchant.defaultHttpClient.setCookieStore(TestConfigMerchant.store);
        HttpResponse response = TestConfigMerchant.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigMerchant.withdraw_income_list_merchant,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigMerchant.withdraw_income_list_merchant,param,result);
        return result;
    }
}
