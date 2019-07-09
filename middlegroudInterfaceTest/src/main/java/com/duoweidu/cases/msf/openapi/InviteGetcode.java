package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class InviteGetcode extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取邀请码")
    public void inviteGetcode() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.INVITE_GETCODE);
        process(true,false);
    }
}
