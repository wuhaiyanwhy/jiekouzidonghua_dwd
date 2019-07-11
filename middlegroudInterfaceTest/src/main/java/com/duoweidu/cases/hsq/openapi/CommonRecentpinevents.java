package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class CommonRecentpinevents extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue", description = "近期开启或成功的拼团列表")
    public void commonRecentpinevents() {
        setUrl("common.recentpinevents.uri");
        process(true,false);
    }
}
