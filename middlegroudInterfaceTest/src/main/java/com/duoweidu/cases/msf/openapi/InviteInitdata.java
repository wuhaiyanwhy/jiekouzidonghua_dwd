package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class InviteInitdata extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "邀请页面初始化数据")
    public void inviteInitdata() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.INVITE_INITDATA);
        process(true,false);
    }
}
