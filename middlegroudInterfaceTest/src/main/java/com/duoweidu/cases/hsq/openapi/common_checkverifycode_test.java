package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_checkverifycode_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "校正验证码")
    public void common_checkverifycode_true() {
        setUrl("common.checkverifycode.uri");
        process(false,false);
    }

}
