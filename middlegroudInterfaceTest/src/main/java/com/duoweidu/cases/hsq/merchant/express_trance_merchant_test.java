package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class express_trance_merchant_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "物流跟踪")
    public void express_trance_merchant_true() {
        setUrl("express.trance.merchant.uri");
    }
}
