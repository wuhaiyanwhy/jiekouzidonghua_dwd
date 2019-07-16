package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class cs_refundlist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "退款管理")
    public void cs_refundlist_true() {
        setUrl("cs.refundlist.uri");
        process();
    }

}
