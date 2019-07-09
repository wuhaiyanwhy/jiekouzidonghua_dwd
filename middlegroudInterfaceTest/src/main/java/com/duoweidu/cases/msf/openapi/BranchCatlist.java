package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class BranchCatlist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "门店分类列表")
    public void branchCatlist() {
        setUrl("branch.catlist.uri");
        process(true,false);
    }
}
