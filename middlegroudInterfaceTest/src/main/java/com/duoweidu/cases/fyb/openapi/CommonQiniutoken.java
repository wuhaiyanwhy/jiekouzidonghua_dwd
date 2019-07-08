package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class CommonQiniutoken extends FybInterfaceTest {

    @Test(description = "获取七牛token")
    public void commonQiniutoken() {
        setUrl("common.qiniutoken.uri");
        process(true,false);
    }
}
