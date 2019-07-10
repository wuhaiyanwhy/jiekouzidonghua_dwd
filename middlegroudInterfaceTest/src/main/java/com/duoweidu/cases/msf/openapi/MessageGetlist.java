package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class MessageGetlist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "消息列表")
    public void messageGetlist() {
        setUrl("message.getlist.uri");
        process(true,false);
    }
}
