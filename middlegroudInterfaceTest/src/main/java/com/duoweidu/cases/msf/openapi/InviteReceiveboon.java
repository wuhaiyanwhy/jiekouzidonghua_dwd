package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 无法领取邀请蜂蜜，暂时无需详细断言
 */
public class InviteReceiveboon extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "领取邀请奖励蜂蜜")
    public void inviteReceiveboon() {
        setUrl("invite.receiveboon.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
    }
}
