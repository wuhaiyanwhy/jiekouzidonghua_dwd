package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class coupon_couponredeem_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "领取优惠券")
    public void coupon_couponredeem_true() {
        setUrl("coupon.couponredeem.uri");
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("code", "123456");
        list.add(param1);
        process(list,false,false);
    }

}
