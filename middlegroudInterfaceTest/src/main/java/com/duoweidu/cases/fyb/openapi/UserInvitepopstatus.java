package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.hsq.ResData;
import org.testng.annotations.Test;

public class UserInvitepopstatus extends FybInterfaceTest {

    private ResData model;

    @Test(description = "邀请人列表不再提醒")
    public void userInvitepopstatus() {
        setUrl("user.invitepopstatus.uri");
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertTrue("res", model.res);
    }
}
