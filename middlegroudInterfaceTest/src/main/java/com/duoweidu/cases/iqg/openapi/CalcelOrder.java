package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class CalcelOrder extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "取消订单")
    public void calcelOrderTrue() {
        url = ConfigFileUrl.getUrlByKey("calcel.order.uri") + SqlDetail.getInstance().getParamValue("orderId");
        pathId = SqlDetail.getInstance().getPathId("calcel.order.uri");
        processDelete(false,false);
        generalAssertStatus();
    }
}
