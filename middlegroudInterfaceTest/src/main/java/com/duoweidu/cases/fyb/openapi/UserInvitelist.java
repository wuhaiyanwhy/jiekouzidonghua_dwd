package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserInvitelist extends FybInterfaceTest {

    @Test(description = "用户邀请明细")
    public void userInvitelist() {
        setUrl("user.invitelist.uri");
        param = "needPagination=1&pageNum=1&pageLimit=10";
        process(true,false);
    }
}
