package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class market_pinactivitiesuserlist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "分享页拼团头像列表")
    public void market_pinactivitiesuserlist_true() {
        setUrl("market.pinactivitiesuserlist.uri");
        param = "pinEventId="+ SqlDetail.getInstance().getParamValue("pinEventId");
        process(true,true);
    }
}
