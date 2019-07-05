package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.IqgConfig;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CouponRedeembypin extends IqgInterfaceTest {

    @Test(dependsOnGroups = "oneCouponResult",description = "一元券店码核销")
    public void couponRedeembypinTrue() {
        setUrl("coupon.redeembypin.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("coupReceiveId", IqgConfig.oneCouponReceivedId));
        list.add(new BasicNameValuePair("pin", SqlDetail.getParamValue(2, "pin")));
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}
