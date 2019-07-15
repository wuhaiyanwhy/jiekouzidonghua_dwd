package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class banner_banneredit_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页banner")
    public void banner_banneredit_true() {

        setUrl("banner.banneredit.uri");
        process(false,false);

    }
}
