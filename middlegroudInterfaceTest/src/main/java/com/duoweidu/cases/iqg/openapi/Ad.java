package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class Ad extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "广告")
    public void ad_true() {
        setUrl("ad.uri");
        param = "position_id=1&zone_id=" + SqlDetail.getParamValue(0, "zone_id");
        process(true,false);
    }
}
