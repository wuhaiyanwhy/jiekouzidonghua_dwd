package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class merchant_address_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "地址管理")
    public void merchant_address_true() {
        setUrl("merchant.address.uri");
    }

}
