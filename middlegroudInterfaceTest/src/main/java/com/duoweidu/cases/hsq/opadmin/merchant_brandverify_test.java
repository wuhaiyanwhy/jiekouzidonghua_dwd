package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class merchant_brandverify_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "品牌授权审核")
    public void merchant_brandverify_true() {

        setUrl("merchant.brandverify.uri");
        process(false,false);

    }
}
