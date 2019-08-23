package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.UserGetAwardVoucherData;
import org.testng.annotations.Test;

public class UserGetAwardVoucherStatus extends FybInterfaceTest {

    private UserGetAwardVoucherData model;

    @Test(description = "获取用户活动红包状态")
    public void userGetAwardVoucherStatus() {
        setUrl("user.GetAwardVoucherStatus.uri");
        process(true,false);
        model = sparseJson(UserGetAwardVoucherData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("awardVoucherStatus", model.awardVoucherStatus);
    }
}
