package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;


import java.util.LinkedList;
import java.util.List;

public class user_bindalipay_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "绑定支付宝")
    public void user_bindalipay_true() {
        setUrl("user.bindalipay.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("authCode","f2e17b9c8c874131a2fbce02e181XA90"));
        process(false,false);
    }

}
