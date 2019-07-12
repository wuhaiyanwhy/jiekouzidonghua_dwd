package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class activity_registration_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "报名营销活动")
    public void activity_registration_true() {
        setUrl("activity.registration.uri");
        process();
    }

}
