package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class OrderTypeAll extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "全部订单")
    public void order_type_all_true() {
        setUrl("order.type.all.uri");
        param = "last_id=0&zone_id=" + SqlDetail.getInstance().getParamValue(0, "zone_id");
        process();
        generalAssertTest(true, false);
    }

}
