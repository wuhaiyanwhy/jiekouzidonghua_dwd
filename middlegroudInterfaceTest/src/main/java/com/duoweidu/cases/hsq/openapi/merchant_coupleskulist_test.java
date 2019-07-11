package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class merchant_coupleskulist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商家拼团列表")
    public void merchant_coupleskulist_true() {
        setUrl("merchant.coupleskulist.uri");
        param = "merchantId="+ SqlDetail.getParamValue("merchantId");
        process(true,false);
    }

}
