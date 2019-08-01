package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 业务配置接口常年为空，暂时无需详细断言
 */
public class common_serviceconfig_test extends HsqInterfaceTest {

    @Test(description = "业务配置")
    public void common_serviceconfig_true() {
        setUrl("common.serviceconfig.uri");
        process(true,false);
    }
}
