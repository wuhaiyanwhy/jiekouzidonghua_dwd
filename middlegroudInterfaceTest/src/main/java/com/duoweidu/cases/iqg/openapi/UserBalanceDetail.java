package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class UserBalanceDetail extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "余额明细")
    public void user_balance_detail_true() {
        setUrl("user.balance_detail.uri");
        process(false,false);
    }

}
