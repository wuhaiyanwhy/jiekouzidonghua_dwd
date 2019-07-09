package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestConfigOpenapi;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class MessageUnread extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "未读消息数")
    public void messageUnread() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.MESSAGE_UNREAD);
        param = "user_id="  + TestConfigOpenapi.userId;
        process(true,false);
    }
}
