package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class activity_pinonlinesearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "抽奖团管理搜索")
    public void activity_pinonlinesearch_true() {

        setUrl("activity.pinonlinesearch.uri");
        process(false,false);

    }
}
