package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.UserGetAwardVoucherData;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserGetAwardVoucher extends FybInterfaceTest {

    private UserGetAwardVoucherData model;

    @Test(description = "用户活动红包领取接口")
    public void userGetAwardVoucher() {
        setUrl("user.getawardvoucher.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
        model = sparseJson(UserGetAwardVoucherData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("awardVoucherStatus", model.awardVoucherStatus);
    }
}
