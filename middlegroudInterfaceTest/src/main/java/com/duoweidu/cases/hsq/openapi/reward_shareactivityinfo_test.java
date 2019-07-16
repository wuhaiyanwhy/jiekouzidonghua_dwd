package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class reward_shareactivityinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取分享活动信息")
    public void reward_shareactivityinfo_true() {
        setUrl("reward.shareactivityinfo.uri");
        param = "activityId=1";
        process(true,false);
    }

}
