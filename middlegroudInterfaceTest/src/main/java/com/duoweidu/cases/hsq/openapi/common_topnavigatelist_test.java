package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_topnavigatelist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页导航栏")
    public void common_topnavigatelist_true() {
        setUrl("common.topnavigatelist.uri");
        param = "sourceType=1";
        process(true,false);
    }

}
