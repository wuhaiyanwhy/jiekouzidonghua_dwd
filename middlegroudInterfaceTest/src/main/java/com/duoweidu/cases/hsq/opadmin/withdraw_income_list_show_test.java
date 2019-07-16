package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class withdraw_income_list_show_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "对账明细")
    public void withdraw_income_list_show_true() throws IOException {

        setUrl("withdraw.income.list.show.uri");
        process();

    }

}
