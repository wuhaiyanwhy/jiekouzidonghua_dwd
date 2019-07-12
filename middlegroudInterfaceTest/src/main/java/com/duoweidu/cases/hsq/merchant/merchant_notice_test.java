package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class merchant_notice_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "店铺公告")
    public void merchant_notice_true() {
        setUrl("merchant.notice.uri");
        process();
    }
}
