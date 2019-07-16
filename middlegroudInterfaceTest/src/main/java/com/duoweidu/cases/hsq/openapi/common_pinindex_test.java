package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_pinindex_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="拼团首页")
    public void common_pinindex_true() {
        setUrl("common.pinindex.uri");
        process(true,true);
    }

}
