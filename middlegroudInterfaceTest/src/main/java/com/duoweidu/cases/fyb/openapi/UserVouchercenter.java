package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserVouchercenter extends FybInterfaceTest {

    @Test(description = "用户代金券首页")
    public void userVouchercenter() {
        setUrl("user.vouchercenter.uri");
        process(true,false);
    }
}
