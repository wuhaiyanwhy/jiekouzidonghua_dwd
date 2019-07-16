package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class activity_gettopiclist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "查看营销活动列表")
    public void activity_gettopiclist_true() {
        setUrl("activity.gettopiclist.uri");
        process();
    }
}
