package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_alipayapploginsign_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝登录密钥")
    public void common_alipayapploginsign_true() {
        setUrl("common.alipayapploginsign.uri");
        process(true,false);
    }

}
