package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 暂时无法砍价（砍价黑名单中），暂时无需详细断言
 */
public class ActivityBargain extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "砍价")
    public void activityBargain() {
        setUrl("activity.bargain.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activity_id", SqlDetail.getInstance().getParamValue("activity_id")));
        list.add(new BasicNameValuePair("udid", SqlDetail.getInstance().getParamValue("udid")));

        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}
