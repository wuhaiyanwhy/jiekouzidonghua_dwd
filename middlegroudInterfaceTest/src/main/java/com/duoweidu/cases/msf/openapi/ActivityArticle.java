package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

/**
 * 活动详情无更多文章，暂时无需详细断言
 */
public class ActivityArticle extends MsfInterfaceTest {

    @Test(description = "活动详情更多文章")
    public void activityArticle() {
        setUrl("activity.article.uri");
        param = "activity_id=" + SqlDetail.getInstance().getParamValue("activity_id");
        process(true,false);
    }
}
