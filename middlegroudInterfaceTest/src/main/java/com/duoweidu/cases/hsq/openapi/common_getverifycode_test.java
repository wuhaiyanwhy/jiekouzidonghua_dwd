package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 只验证code码，暂时无需详细断言
 */
public class common_getverifycode_test extends HsqInterfaceTest {

    @Test(description = "获取验证码")
    public void common_getverifycode_true() {
        setUrl("common.getverifycode.uri");
        //无法频繁的获取验证码，先禁用
//        param = "&mobile=18621815402&type=5";
        process(false,false);
    }
}
