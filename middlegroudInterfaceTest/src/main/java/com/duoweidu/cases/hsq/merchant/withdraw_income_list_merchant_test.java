package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class withdraw_income_list_merchant_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "收入明细列表")
    public void withdraw_income_list_merchant_true () {
        setUrl("withdraw.income.list.merchant.uri");
        process();
    }

}
