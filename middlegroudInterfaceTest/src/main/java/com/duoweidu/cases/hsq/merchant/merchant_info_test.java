package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class merchant_info_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "商户信息")
    public void merchant_info_true() {
        setUrl("merchant.info.uri");
        process();
    }

}
