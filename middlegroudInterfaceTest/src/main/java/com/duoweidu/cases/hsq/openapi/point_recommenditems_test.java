package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class point_recommenditems_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="积分商品推荐列表")
    public void point_recommenditems_true() {
        setUrl("point.recommenditems.uri");
        param = "item_selected_cnt=3&data_rule=1";
        process(false,false);
        generalAssertTest();
    }
}
