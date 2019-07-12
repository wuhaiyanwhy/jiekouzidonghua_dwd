package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ActivityBargain extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "砍价")
    public void activityBargain() {
        setUrl("activity.bargain.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activity_id", SqlDetail.getParamValue("activity_id")));
        list.add(new BasicNameValuePair("udid", SqlDetail.getParamValue("udid")));

        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}
