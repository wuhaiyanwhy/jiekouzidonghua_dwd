package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 此接口基本不用，暂时无需详细断言
 */
public class common_qiniutoken_test extends HsqInterfaceTest {

    @Test(description = "获取青牛")
    public void common_qiniutoken_true() {
        setUrl("common.qiniutoken.uri");
        process(true,false);
    }
}
