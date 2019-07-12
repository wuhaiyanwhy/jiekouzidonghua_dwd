package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class merchant_merchantinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取商户信息")
    public void merchant_merchantinfo_true() {
        setUrl("merchant.merchantinfo.uri");
        param = "merchantId="+ SqlDetail.getParamValue("merchantId");
        process(true,false);
    }
}
