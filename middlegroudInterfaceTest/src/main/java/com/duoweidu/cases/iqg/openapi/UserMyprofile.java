package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class UserMyprofile extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户基本信息")
    public void user_myprofile_true() {
        setUrl("user.myprofile.uri");
        process(true,false);
    }
}
