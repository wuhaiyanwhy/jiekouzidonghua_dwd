package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class system_systemnotice_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商户端公告")
    public void system_systemnotice_true() {

        setUrl("system.systemnotice.uri");
        process(false,false);

    }
}
