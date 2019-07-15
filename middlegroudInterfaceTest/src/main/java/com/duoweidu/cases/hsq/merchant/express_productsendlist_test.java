package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class express_productsendlist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "发货")
    public void express_productsendlist_true() {
        setUrl("express.productsendlist.uri");
        process();
    }

}
