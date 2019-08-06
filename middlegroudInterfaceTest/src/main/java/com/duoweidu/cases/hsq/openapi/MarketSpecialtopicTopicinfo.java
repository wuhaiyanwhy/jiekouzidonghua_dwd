package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class MarketSpecialtopicTopicinfo extends HsqInterfaceTest {

    @Test(description = "新专题")
    public void marketSpecialtopicTopicinfo() {
        setUrl("market.specialtopic.topicinfo.uri");
        param = "code=" + SqlDetail.getInstance().getParamValue("newCode");
        process(true, true);
    }
}
