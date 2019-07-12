package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class BranchDetail extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "门店详情")
    public void branchDetail() {
        setUrl("branch.detail.uri");
        param = "id=" + SqlDetail.getParamValue("branch_id");
        process(true,false);
    }
}
