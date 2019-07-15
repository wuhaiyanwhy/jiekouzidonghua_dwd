package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class system_adminappset_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "APP升级配置")
    public void system_adminappset_true() {

        setUrl("system.adminappset.uri");
        process(false,false);

    }

}
