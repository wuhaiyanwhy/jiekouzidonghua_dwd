package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.TestConfigOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class activity_pinlottery_edit_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "抽奖活动")
    public void activity_pinlottery_edit_true() {

        setUrl("activity.pinlottery.edit.uri");

        process();


    }

    private String getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfigOpadmin.activity_pinlottery_edit);
        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);

        GeneralAssert.codeTest(response,TestConfigOpadmin.activity_pinlottery_edit,param);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        GeneralAssert.resultTest(TestConfigOpadmin.activity_pinlottery_edit,param,result);
        return result;
    }
}
