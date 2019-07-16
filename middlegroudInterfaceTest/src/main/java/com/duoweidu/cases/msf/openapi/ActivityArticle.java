package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ActivityArticle extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动详情更多文章")
    public void activityArticle() {
        setUrl("activity.article.uri");
        param = "activity_id=" + SqlDetail.getInstance().getParamValue("activity_id");
        process(true,false);
    }
}
