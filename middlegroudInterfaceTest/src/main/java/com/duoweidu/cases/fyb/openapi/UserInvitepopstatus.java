package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserInvitepopstatus extends FybInterfaceTest {

    @Test(description = "邀请人列表不再提醒")
    public void userInvitepopstatus() {
        setUrl("user.invitepopstatus.uri");
        process(true,false);
    }
}
