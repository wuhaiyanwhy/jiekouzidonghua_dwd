package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ItemDetail extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商品详情")
    public void item_detail_true() {
        url = ConfigFileUrl.getUrlByKey("item.detail.uri") + "/" + SqlDetail.getParamValue(2, "activityId");
        pathId = SqlDetail.getPathId("item.detail.uri");
        process(true,false);
    }
}
