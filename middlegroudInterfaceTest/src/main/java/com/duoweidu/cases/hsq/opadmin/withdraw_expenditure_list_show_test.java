package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class withdraw_expenditure_list_show_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商户支出明细")
    public void withdraw_expenditure_list_show_true() {

        setUrl("withdraw.expenditure.list.show.uri");
        process();

    }

}
