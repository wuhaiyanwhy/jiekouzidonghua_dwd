package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class order_userordersearch_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单搜索")
    public void order_userordersearch_true() {
        setUrl("order.userordersearch.uri");
        param = "&q=测试&pageLimit=20&pageNum=1";
        process(true,true);
    }
}
