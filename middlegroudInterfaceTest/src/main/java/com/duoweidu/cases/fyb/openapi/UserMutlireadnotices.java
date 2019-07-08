package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserMutlireadnotices extends FybInterfaceTest {

    @Test(description = "系统通知消息已读")
    public void userMutlireadnotices() throws IOException {
        setUrl("user.mutlireadnotices.uri");
        process(true,false);
    }

}
