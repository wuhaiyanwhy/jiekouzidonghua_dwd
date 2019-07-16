package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class merchant_productskulist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "商户列表")
    public void merchant_productskulist_true() {
        setUrl("merchant.productskulist.uri");
        process();
    }
}
