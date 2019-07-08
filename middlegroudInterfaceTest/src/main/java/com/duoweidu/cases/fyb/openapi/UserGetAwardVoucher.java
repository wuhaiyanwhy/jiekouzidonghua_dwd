package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserGetAwardVoucher extends FybInterfaceTest {

    @Test(description = "用户活动红包领取接口")
    public void userGetAwardVoucher() {
        setUrl("user.getawardvoucher.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }
}
