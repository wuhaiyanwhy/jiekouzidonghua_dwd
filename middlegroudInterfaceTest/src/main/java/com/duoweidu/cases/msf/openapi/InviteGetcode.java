package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class InviteGetcode extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取邀请码")
    public void inviteGetcode() {
        setUrl("invite.getcode.uri");
        process(true,false);
    }
}
