package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class activity_topic_test extends HsqMerchantInterfaceTest {

    //用来储存返回结果
    private String result;

    @Test(groups = "loginTrue",description = "查看营销活动")
    public void activity_topic_true() {
        setUrl("activity.topic.uri");
        process();
    }
}
