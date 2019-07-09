package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class InviteReceiveboon extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "领取邀请奖励蜂蜜")
    public void inviteReceiveboon() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.INVITE_RECEIVEBOON);
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
    }
}
