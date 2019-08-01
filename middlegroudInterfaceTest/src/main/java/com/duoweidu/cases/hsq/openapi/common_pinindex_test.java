package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 此接口基本不用，暂时无需详细断言
 */
public class common_pinindex_test extends HsqInterfaceTest {

    @Test(description ="拼团首页")
    public void common_pinindex_true() {
        setUrl("common.pinindex.uri");
        process(true,true);
    }

}
