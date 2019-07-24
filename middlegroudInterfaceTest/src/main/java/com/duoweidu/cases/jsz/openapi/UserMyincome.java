package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.testng.annotations.Test;

public class UserMyincome extends JszInterfaceTest {

    @Test(description = "我的收益")
    public void userMyincome() {
        setUrl("user.myincome.uri");
        process(true, false);
    }
}
