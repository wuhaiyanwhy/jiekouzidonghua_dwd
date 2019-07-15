package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class market_specialtopiccomponentgroupskulist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "五福页尾铺品")
    public void market_specialtopiccomponentgroupskulist_true() {
        setUrl("market.specialtopiccomponentgroupskulist.uri");
        param = "componentGroupId=" + SqlDetail.getInstance().getParamValue("componentGroupId") + "&pageNum=1&pageLimit=20&topicCode=" + SqlDetail.getInstance().getParamValue("wufuTopicCode");
        process(true,false);
    }

}
