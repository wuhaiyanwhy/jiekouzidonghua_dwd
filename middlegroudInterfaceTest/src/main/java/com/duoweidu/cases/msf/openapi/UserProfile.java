package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class UserProfile extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "个人中心详情页")
    public void userProfile() {
        setUrl("user.profile.uri");
        param = "page_num=1&page_limit=20";
        process(true,false);
    }
}
