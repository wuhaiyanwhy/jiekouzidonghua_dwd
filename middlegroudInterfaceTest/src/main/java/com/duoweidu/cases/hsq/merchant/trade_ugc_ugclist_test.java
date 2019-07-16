package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class trade_ugc_ugclist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "评价管理")
    public void trade_ugc_ugclist_true() {
        setUrl("trade.ugc.ugclist.uri");
        process();
    }

}
