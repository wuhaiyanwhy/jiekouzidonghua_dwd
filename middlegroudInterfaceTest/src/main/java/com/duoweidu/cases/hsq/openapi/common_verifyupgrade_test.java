package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_verifyupgrade_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "app检查更新")
    public void common_verifyupgrade_true() {
        setUrl("common.verifyupgrade.uri");
        param  = "terminal=android";
        process(true,false);
    }
}
