package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class launchbanner_banneronlinelist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "启动页列表")
    public void launchbanner_banneronlinelist_true() {

        setUrl("launchbanner.banneronlinelist.uri");
        process(false,false);

    }
}
