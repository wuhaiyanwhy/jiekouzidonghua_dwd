package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import org.testng.annotations.Test;

public class Tradecenter0rdersuccessv1 extends HsqInterfaceTest {
    @Test(dependsOnGroups = "submitOrder",description = "普通订单支付成功回调")
    public void tradecenterOrdersuccessv1(){
        setUrl("tradecenter.tradecenter.uri");
        param= "orderIds="+HsqOpenapiConfig.orderIds;
        process(true,false);
    }
}
