package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class activity_pointsku_edit_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝活动管理")
    public void activity_pointsku_edit_true() {

        setUrl("activity.pointsku.edit.uri");
        process(false,false);

    }
}
