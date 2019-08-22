package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 无数据，暂时无需详细断言
 */
public class CommonRecentpinevents extends HsqInterfaceTest {

    @Test(description = "近期开启或成功的拼团列表")
    public void commonRecentpinevents() {
        setUrl("common.recentpinevents.uri");
        process(true,false);
    }
}
