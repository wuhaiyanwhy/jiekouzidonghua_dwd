package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class withdraw_expenditure_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "贷款账户")
    public void withdraw_expenditure_true() {
        setUrl("withdraw.expenditure.uri");
        process();
    }
}
