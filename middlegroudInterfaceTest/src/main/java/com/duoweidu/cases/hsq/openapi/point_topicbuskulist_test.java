package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class point_topicbuskulist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取积分信息列表")
    public void point_topicbuskulist_true() {
        setUrl("point.topicbuskulist.uri");
        param = "pointChannelId=1&topicCode=" + SqlDetail.getParamValue("topicCode");
        process(true,false);

    }

}
