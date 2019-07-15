package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class coupon_alipay_autopush_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝自动推券活动列表")
    public void coupon_alipay_autopush_list_true() {
        setUrl("coupon.alipay.autopush.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);

    }

}
