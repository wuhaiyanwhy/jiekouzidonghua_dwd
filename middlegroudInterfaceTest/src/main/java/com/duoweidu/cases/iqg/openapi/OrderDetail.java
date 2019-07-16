package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class OrderDetail extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单详情")
    public void order_detail_true() {
        url = ConfigFileUrl.getUrlByKey("order.detail.uri") + "/" + SqlDetail.getInstance().getParamValue("orderId");
        pathId = SqlDetail.getInstance().getPathId("order.detail.uri");
        process(true,false);
    }
}
