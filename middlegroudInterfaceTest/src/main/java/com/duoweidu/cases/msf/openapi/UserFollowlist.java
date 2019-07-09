package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class UserFollowlist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "关注/粉丝列表")
    public void userFollowlist() {
        setUrl("user.followlist.uri");
        param = "type=1";
        process(true,true);
    }

}
