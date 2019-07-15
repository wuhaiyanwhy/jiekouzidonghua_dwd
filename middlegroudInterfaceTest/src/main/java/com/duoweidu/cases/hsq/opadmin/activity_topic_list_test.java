package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class activity_topic_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "发布SABC活动列表")
    public void activity_topic_list_true() {

        setUrl("activity.topic.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }

}
