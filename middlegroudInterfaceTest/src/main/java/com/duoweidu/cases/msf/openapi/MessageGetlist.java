package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class MessageGetlist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "消息列表")
    public void messageGetlist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.MESSAGE_GETLIST);
        process(true,false);
    }
}
