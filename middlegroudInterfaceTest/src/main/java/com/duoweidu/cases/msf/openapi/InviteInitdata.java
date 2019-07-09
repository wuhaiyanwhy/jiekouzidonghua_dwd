package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class InviteInitdata extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "邀请页面初始化数据")
    public void inviteInitdata() {
        setUrl("invite.initdata.uri");
        process(true,false);
    }
}
