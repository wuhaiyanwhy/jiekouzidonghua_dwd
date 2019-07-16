package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class activity_goods_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商品列表排序管理")
    public void activity_goods_index_true() {
        setUrl("activity.goods.index.uri");
        process(false, false);

    }
}
