package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class UserCoupon extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "一元券订单列表")
    public void user_coupon_true() {
        setUrl("user.coupon.uri");
        param = "pageLimit=20&pageNum=1&needPagination=1&status=1";
        process(true,false);
    }
}
