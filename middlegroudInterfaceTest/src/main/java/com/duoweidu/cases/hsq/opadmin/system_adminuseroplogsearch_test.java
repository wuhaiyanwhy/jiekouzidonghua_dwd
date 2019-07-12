package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class system_adminuseroplogsearch_test {

    //用来储存参数信息
    private String param;
    //用来储存返回结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "操作日志搜索")
    public void system_adminuseroplogsearch_true() throws IOException {

        System.out.println(TestConfigOpadmin.system_adminuseroplogsearch);

        String results = getJsonResult();


    }

    private String getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.system_adminuseroplogsearch);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigOpadmin.system_adminuseroplogsearch,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.system_adminuseroplogsearch,param,result);
        return result;
    }
}
