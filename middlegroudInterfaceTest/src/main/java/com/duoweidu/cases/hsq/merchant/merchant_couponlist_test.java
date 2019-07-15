package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class merchant_couponlist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "优惠券管理列表")
    public void merchant_couponlist_true() {
        setUrl("merchant.couponlist.uri");
        process();
    }
}
