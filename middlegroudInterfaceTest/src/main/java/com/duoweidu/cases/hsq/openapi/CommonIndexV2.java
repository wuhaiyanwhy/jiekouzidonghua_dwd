package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class CommonIndexV2 extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "新首页接口")
    public void commonIndexV2() {
        setUrl("common.index_v2.uri");
        param = "type=1";
        process(true,false);
    }
}
