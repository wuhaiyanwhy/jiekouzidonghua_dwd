package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class merchant_promotions_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "促销管理")
    public void merchant_promotions_true() {
        setUrl("merchant.promotions.uri");
        process();
    }

}
