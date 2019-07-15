package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class system_notice_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户端公告列表")
    public void system_notice_list_true() {

        setUrl("system.notice.list.uri");
        process(false,false);

    }
}
