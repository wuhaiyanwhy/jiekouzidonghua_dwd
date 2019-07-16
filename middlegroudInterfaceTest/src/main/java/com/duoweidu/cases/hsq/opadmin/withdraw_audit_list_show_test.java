package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class withdraw_audit_list_show_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "提现审核管理")
    public void withdraw_audit_list_show_true() {

        setUrl("withdraw.audit.list.show.uri");
        process();

    }

}
