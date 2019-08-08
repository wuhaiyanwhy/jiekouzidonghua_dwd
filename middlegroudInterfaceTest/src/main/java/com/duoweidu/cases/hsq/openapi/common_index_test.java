package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 首页接口已用新的，暂时无需详细断言
 */
public class common_index_test extends HsqInterfaceTest {

    @Test(description ="首页接口")
    public void common_index_true() {
        setUrl("common.index.uri");
        param = "type=1";
        process(true,false);
    }
}
