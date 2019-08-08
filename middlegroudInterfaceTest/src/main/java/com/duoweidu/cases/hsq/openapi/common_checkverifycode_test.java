package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 只验证code码，暂时无需详细断言
 */
public class common_checkverifycode_test extends HsqInterfaceTest {

    @Test(description = "校正验证码")
    public void common_checkverifycode_true() {
        setUrl("common.checkverifycode.uri");
        process(false,false);
    }

}
