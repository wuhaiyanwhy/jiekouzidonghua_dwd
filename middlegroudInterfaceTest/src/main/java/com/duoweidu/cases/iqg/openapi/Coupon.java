package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Coupon extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加券")
    public void couponTrue() {
        setUrl("coupon.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code","123456"));
        list.add(new BasicNameValuePair("type","input"));
        process(list,false,false);
    }
}
