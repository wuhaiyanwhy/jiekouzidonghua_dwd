package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class trade_productsoldlist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "已卖出的宝贝")
    public void trade_productsoldlist_true() {
        setUrl("trade.productsoldlist.uri");
        process();
    }
}
