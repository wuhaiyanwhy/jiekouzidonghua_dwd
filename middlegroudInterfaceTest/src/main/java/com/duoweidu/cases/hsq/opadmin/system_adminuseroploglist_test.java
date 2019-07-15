package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class system_adminuseroploglist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "操作日志列表")
    public void system_adminuseroploglist_true() {

        setUrl("system.adminuseroploglist.uri");
        process(2,true,false);

    }
}
