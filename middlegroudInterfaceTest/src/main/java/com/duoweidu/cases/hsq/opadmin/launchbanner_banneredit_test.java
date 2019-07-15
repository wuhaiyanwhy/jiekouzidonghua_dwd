package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class launchbanner_banneredit_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "启动页")
    public void launchbanner_banneredit_true() {

        setUrl("launchbanner.banneredit.uri");
        process(false,false);

    }

}
