package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class FeedbackApplyrefund extends JszInterfaceTest {

    @Test(description = "申请退款")
    public void feedbackApplyrefund() {
        setUrl("feedback.applyrefund.uri");
        List<NameValuePair> list = new LinkedList<>();
        //没有退款订单
        process(list,false, false);
    }
}
