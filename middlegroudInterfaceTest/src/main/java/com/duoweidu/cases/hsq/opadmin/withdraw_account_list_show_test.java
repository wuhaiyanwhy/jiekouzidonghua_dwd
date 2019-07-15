package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class withdraw_account_list_show_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商家提现")
    public void withdraw_account_list_show_true() {

        setUrl("withdraw.account.list.show.uri");
        process();

    }

}
