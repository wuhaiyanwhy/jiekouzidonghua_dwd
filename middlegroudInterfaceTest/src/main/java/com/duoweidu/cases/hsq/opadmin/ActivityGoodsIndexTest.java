package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class ActivityGoodsIndexTest extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商品列表排序管理")
    public void activityGoodsIndexTrue() {
        setUrl("activity.goods.index.uri");
        process();

    }
}
