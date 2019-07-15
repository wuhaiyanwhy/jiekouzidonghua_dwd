package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class coupon_alipay_usage_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝优惠券使用详情")
    public void coupon_alipay_usage_true() {
        setUrl("coupon.alipay.usage.uri");
        process(false,false);

    }
}
