package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

public class ActivityArticle extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动详情更多文章")
    public void activityArticle() {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ACTIVITY_ARTICLE);
        param = "activity_id=" + TestSql.getValue("activity_id");
        process(true,false);
    }
}
