package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class BarginAvatar extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "今日砍价用户头像")
    public void barginAvatarTrue() {
        setUrl("today_bargin.use_avatar.uri");
        param = "zone_id=" + SqlDetail.getParamValue(0, "zone_id") +
                "&campaign_branch_id=" + SqlDetail.getParamValue(2, "activityId");
        process(false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}
