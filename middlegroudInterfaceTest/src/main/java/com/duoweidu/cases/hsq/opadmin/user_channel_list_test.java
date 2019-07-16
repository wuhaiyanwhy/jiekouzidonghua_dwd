package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_channel_list_test extends HsqOpadminInterfaceTest {


    @Test(dependsOnGroups = "loginTrue",description = "渠道信息列表")
    public void user_channel_list_true() {
        setUrl("user.channel.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list);

    }
}
