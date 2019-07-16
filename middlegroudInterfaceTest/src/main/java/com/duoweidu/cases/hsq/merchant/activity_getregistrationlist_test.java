package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class activity_getregistrationlist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "报名营销活动列表")
    public void activity_getregistrationlist_true() {
        setUrl("activity.getregistrationlist.uri");
        process();
    }
}
