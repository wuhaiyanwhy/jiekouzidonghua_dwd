package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class CommonInitconfig extends FybInterfaceTest {

    @Test(description = "初始化配置")
    public void commonInitconfig() {
        setUrl("common.initconfig.uri");
        process(true,false);
    }
}
