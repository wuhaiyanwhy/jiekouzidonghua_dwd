package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class activity_pointsku_config_administration_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝活动商详管理")
    public void activity_pointsku_config_administration_true()  {

        setUrl("activity.pointsku.config.administration.uri");
        process(false,false);

    }
}
