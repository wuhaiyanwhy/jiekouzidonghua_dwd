package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class merchant_couponverify_test {

        //用来储存参数信息
        private String param;
        //用来储存返回结果
        private String result;

        @Test(dependsOnGroups = "loginTrue",description = "商家优惠券审核")
        public void merchant_couponverify_true() throws IOException {

            System.out.println(TestConfigOpadmin.merchant_couponverify);

            String results = getJsonResult();


        }

        private String getJsonResult() throws IOException {

            HttpGet get = new HttpGet(TestConfigOpadmin.merchant_couponverify);
            TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
            HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);

            GeneralAssert.codeTest(response,TestConfigOpadmin.merchant_couponverify,param);

            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println("接口返回： " + result);

            GeneralAssert.resultTest(TestConfigOpadmin.merchant_couponverify,param,result);
            return result;
        }
}
