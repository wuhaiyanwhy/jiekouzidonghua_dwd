package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class system_notice_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户端公告")
    public void system_notice_true() {

        setUrl("system.notice.uri");
        process(false,false);

    }
}
