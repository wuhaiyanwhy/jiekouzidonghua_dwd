package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class withdraw_audit_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "提现审核列表")
    public void withdraw_audit_list_true() {

        setUrl("withdraw.audit.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, true, true);
    }
}
