package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_index_v1_test extends HsqInterfaceTest {


    @Test(dependsOnGroups = "loginTrue",description ="新首页接口")
    public void common_index_v1_true() {
        setUrl("common.index_v1.uri");
        param = "type=1";
        process(true,true);
    }

}
