package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class coupon_alipay_template_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝优惠券模板")
    public void coupon_alipay_template_true() {
        setUrl("coupon.alipay.template.uri");
        process(false,false);

    }
}
