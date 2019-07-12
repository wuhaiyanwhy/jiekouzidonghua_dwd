package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class Item extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页商品活动")
    public void item_true() {
        setUrl("item.uri");
        param = "category_id=0&last_id=0&zone_id=" + SqlDetail.getParamValue(0, "zone_id");
        process(true,false);
    }
}
