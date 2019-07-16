package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class coupon_alipay_autopush_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝自动推券活动")
    public void coupon_alipay_autopush_true() {
        setUrl("coupon.alipay.autopush.uri");
        process(false,false);

    }
}
