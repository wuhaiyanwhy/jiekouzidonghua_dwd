package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class trade_merchant_ugclist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "评价管理列表")
    public void trade_merchant_ugclist_true() {
        setUrl("trade.merchant.ugclist.uri");
        process();
    }
}
