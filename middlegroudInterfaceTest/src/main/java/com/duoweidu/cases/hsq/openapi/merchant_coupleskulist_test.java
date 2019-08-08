package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

/**
 * 列表为空，暂时无需详细断言
 */
public class merchant_coupleskulist_test extends HsqInterfaceTest {

    @Test(description = "商家拼团列表")
    public void merchant_coupleskulist_true() {
        setUrl("merchant.coupleskulist.uri");
        param = "merchantId="+ SqlDetail.getInstance().getParamValue("merchantId");
        process(true,false);
    }

}
