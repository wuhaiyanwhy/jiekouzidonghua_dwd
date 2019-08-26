package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

/**
 * 无法频繁获取验证码，暂时先禁用
 */
public class CommonGetverifycode extends FybInterfaceTest {


    @Test(description = "获取验证码")
    public void commonGetverifycode() {
        setUrl("common.getverifycode.uri");
        //无法频繁的获取验证码，先禁用
//        param = "&mobile=18621815402&type=5";
        process(false,false);
    }
}
