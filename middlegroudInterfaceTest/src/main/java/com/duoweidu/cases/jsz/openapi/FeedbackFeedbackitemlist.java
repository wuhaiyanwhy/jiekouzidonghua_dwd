package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;


public class FeedbackFeedbackitemlist extends JszInterfaceTest {

    public void feedbackitemlist(String type) {
        setUrl("feedback.feedbackitemlist.uri");
        param = "type=" + type;
        process(true, false);

    }

    @Test(dependsOnGroups = "UserLogincallback",description = "退款原因列表1")
    public void feedbackFeedbackitemlist1() {
        feedbackitemlist(SqlDetail.getInstance().getParamValue(2,"type1"));
    }

    @Test(dependsOnGroups = "UserLogincallback",description = "退款原因列表2")
    public void feedbackFeedbackitemlist2() {
        feedbackitemlist(SqlDetail.getInstance().getParamValue(2,"type2"));

    }
}
