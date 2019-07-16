package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_index_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="首页接口")
    public void common_index_true() {
        setUrl("common.index.uri");
        param = "type=1";
        process(true,false);
    }
}
