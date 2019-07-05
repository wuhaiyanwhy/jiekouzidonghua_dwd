package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class UserAgreementChange extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户协议")
    public void user_agreement_change_test() {
        setUrl("user.agreement_change.uri");
        process(true,false);
    }
}
