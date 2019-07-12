package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class content_topnavigatesearch_test {

    //用来储存参数信息
    private String param;
    //用来储存返回的结果
    private String result;

    @Test(dependsOnGroups = "loginTrue",description = "导航管理搜索")
    public void content_topnavigatesearch_true() throws IOException {
        System.out.println(TestConfigOpadmin.content_topnavigatesearch);

        String results = getJsonResult();


    }


    private String getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.content_topnavigatesearch);

        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);

        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);
        GeneralAssert.codeTest(response,TestConfigOpadmin.content_topnavigatesearch,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.content_topnavigatesearch,param,result);

        return result;
    }
}
