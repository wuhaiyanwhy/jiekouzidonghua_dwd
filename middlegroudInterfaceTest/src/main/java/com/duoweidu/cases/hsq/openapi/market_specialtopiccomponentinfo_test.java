package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class market_specialtopiccomponentinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "五福专题页")
    public void market_specialtopiccomponentinfo_true() {
        setUrl("market.specialtopiccomponentinfo.uri");
        param = "topicCode=" + SqlDetail.getParamValue("wufuTopicCode");
        process(true,false);
    }
}
