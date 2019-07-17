package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class FeedbackApplyrefund extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "申请退款")
    public void feedbackApplyrefund() {
        setUrl("feedback.applyrefund.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderId", ""));
        list.add(new BasicNameValuePair("feedbackItemId", ""));
        list.add(new BasicNameValuePair("feedback", ""));
        process(list,true, false);
    }
}
