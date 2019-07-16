package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class merchant_merchantverify_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "基本信息审核")
    public void merchant_merchantverify_true() {

        setUrl("merchant.merchantverify.uri");
        process(false,false);

    }
}
