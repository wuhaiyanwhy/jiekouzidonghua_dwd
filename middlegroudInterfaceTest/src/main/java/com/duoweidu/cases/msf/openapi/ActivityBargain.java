package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ActivityBargain extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "砍价")
    public void activityBargain() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ACTIVITY_BARGAIN);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activity_id", TestSql.getValue("activity_id")));
        list.add(new BasicNameValuePair("platform", TestSql.getValue("platform", 4)));
        list.add(new BasicNameValuePair("udid",TestSql.getValue("udid")));

        process(list,false,false);
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            generalAssertTest(false);
        }
    }
}
