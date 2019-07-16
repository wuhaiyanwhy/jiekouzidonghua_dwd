package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class withdraw_expenditure_list_merchant_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "贷款账户列表")
    public void withdraw_expenditure_list_merchant_true() {
        setUrl("withdraw.expenditure.list.merchant.uri");
        process();
    }
}
