package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class coupon_alipay_autopush_test {


    //用来储存参数信息
    private String param;
    //用来储存返回的结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "支付宝自动推券活动")
    public void coupon_alipay_autopush_true() throws IOException {
        System.out.println(TestConfigOpadmin.coupon_alipay_autopush);

        String results = getJsonResult();


    }


    private String getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.coupon_alipay_autopush);

        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);

        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);
        GeneralAssert.codeTest(response,TestConfigOpadmin.coupon_alipay_autopush,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.coupon_alipay_autopush,param,result);

        return result;
    }
}
