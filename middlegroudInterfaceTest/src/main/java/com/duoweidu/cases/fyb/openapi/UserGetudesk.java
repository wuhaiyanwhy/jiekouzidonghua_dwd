package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserGetudesk extends FybInterfaceTest {

    @Test(description = "udesk")
    public void userGetudesk() {
        setUrl("user.getudesk.uri");
        process(true,false);
    }
}
