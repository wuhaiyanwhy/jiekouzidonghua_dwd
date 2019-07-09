package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class MessageType extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "消息首页")
    public void messageType() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.MESSAGE_TYPE);
        process(true,false);
    }
}
