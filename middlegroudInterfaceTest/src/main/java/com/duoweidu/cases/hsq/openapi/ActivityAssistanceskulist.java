package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;


public class ActivityAssistanceskulist extends HsqInterfaceTest {

    @Test(description = "助力免单列表")
    public void activityAssistanceskulist() {
        setUrl("activity.assistanceskulist.uri");
        param = "activityType=1&pageNum=1&pageLimit=10";
        process(true,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(true);
        }
    }
}
