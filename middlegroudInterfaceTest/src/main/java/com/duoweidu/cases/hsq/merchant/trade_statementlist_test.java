package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class trade_statementlist_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "对账明细列表")
    public void trade_statementlist_true() {
        setUrl("trade.statementlist.uri");
        process();
    }
}
