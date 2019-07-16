package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class BargainToday extends IqgInterfaceTest {

    @Test(dependsOnGroups = "itemBargain",description = "今日关注")
    public void bargainTodayTrue() {
        url = ConfigFileUrl.getUrlByKey("bargain.today.uri");
        pathId = SqlDetail.getInstance().getPathId("bargain.today.uri");
        process(false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false, true);
        }
    }
}
