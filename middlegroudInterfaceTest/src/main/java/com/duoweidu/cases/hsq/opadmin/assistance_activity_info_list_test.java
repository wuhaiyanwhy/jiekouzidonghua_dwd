package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class assistance_activity_info_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "助力免单活动管理列表")
    public void assistance_activity_info_list_true() {

        setUrl("assistance.activity.info.list.uri");
        process(2,true,false);

    }
}
