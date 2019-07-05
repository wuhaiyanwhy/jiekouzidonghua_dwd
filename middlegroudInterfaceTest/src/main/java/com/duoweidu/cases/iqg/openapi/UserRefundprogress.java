package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.IqgConfig;
import org.testng.annotations.Test;

public class UserRefundprogress extends IqgInterfaceTest {

    @Test(groups = "oneCouponResult",description = "一元券退款详情")
    public void userRefundprogressTrue() {
        setUrl("user.refundprogress.uri");
        param = "id=" + IqgConfig.oneCouponReceivedId;
        process(false,false);
    }
}
