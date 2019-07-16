package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class withdraw_income_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "收入明细")
    public void withdraw_income_true() {
        setUrl("withdraw.income.uri");
        process();
    }
}
