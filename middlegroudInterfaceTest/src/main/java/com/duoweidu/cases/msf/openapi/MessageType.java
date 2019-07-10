package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class MessageType extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "消息首页")
    public void messageType() {
        setUrl("message.type.uri");
        process(true,false);
    }
}
