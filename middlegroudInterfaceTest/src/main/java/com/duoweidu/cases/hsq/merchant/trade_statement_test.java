package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class trade_statement_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "对账明细")
    public void trade_statement_true() {
        setUrl("trade.statement.uri");
        process();
    }
}
