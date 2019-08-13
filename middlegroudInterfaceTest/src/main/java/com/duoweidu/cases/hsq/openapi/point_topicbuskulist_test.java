package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

/**
 * 暂时无需详细断言
 */
public class point_topicbuskulist_test extends HsqInterfaceTest {

    @Test(description = "获取积分专题sku信息列表(老专题)")
    public void point_topicbuskulist_true() {
        setUrl("point.topicbuskulist.uri");
        param = "pointChannelId=1&topicCode=" + SqlDetail.getInstance().getParamValue("topicCode");
        process(true,false);

    }

}
