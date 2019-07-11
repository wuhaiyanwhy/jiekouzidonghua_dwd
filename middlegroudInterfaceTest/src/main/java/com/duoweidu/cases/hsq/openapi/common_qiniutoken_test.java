package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_qiniutoken_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取青牛")
    public void common_qiniutoken_true() {
        setUrl("common.qiniutoken.uri");
        process(true,false);
    }
}
