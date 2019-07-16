package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class system_systemconfig_set_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "后台系统配置")
    public void system_systemconfig_set_true() {

        setUrl("system.systemconfig.set.uri");
        process(false,false);

    }
}
