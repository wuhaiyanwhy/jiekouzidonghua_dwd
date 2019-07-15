package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class point_topicinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取积分专题sku信息")
    public void point_topicinfo_true() {
        setUrl("point.topicinfo.uri");
        param = "pointChannelId=1&topicCode=" + SqlDetail.getInstance().getParamValue("topicCode");
        process(true,false);
    }

}
