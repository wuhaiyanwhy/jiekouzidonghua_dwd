package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class Coindetail extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "金币明细")
    public void coindetail_true() {
        setUrl("coindetail.uri");
        process(true,true);
    }
}
