package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class StatsUserShare extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "分享")
    public void stats_user_share_true() {
        setUrl("stats.user_share.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("campaign_branch_id", SqlDetail.getParamValue(2, "activityId")));
        list.add(new BasicNameValuePair("type","1"));
        process(list,false,false);
        generalAssertStatus();
    }
}
