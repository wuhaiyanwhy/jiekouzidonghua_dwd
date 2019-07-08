package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserGetAwardVoucherStatus extends FybInterfaceTest {

    @Test(description = "获取用户活动红包状态")
    public void userGetAwardVoucherStatus() {
        setUrl("user.GetAwardVoucherStatus.uri");
        process(true,false);
    }
}
