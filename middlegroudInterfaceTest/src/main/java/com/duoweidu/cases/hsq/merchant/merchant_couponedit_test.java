package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class merchant_couponedit_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "优惠券管理")
    public void merchant_couponedit_true() {
        setUrl("merchant.couponedit.uri");
    }

}
