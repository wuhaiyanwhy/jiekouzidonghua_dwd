package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 首页接口已用新的，暂时无需详细断言
 */
public class common_index_v1_test extends HsqInterfaceTest {


    @Test(description ="新首页接口")
    public void common_index_v1_true() {
        setUrl("common.index_v1.uri");
        param = "type=1";
        process(true,true);
    }

}
