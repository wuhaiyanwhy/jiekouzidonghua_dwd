package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;

import org.testng.annotations.Test;


public class activity_pinlottery_edit_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "抽奖活动")
    public void activity_pinlottery_edit_true() {

        setUrl("activity.pinlottery.edit.uri");

        process(false, false);

    }
}
