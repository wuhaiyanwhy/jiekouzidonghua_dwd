package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class CommonStaticcontent extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取静态页内容（用户协议）")
    public void commonStaticcontent() {
        setUrl("common.staticcontent.uri");
        param = "q=terms_of_privacy";
        process(true,false);
    }
}
