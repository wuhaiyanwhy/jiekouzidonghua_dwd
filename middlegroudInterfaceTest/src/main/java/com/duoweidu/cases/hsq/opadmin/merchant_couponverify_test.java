package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class merchant_couponverify_test extends HsqOpadminInterfaceTest {

        @Test(dependsOnGroups = "loginTrue",description = "商家优惠券审核")
        public void merchant_couponverify_true() {

            setUrl("merchant.couponverify.uri");
            process(false,false);

        }
}
