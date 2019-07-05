package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class DeleteCoupon extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "删除/使用优惠券，这里是使用")
    public void deleteCouponTrue() {
        setUrl("delete.coupon.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
    }
}
