package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class coupon_alipay_activity_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝领券活动")
    public void coupon_alipay_activity_index_true() {
        setUrl("coupon.alipay.activity.index.uri");
        process(false,false);

    }
}
