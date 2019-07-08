package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class CommonNoticestatus extends FybInterfaceTest {

    @Test(description = "消息状态查询")
    public void commonNoticestatus() {
        setUrl("common.noticestatus.uri");
        param = "cityId=2";
        process(true,false);
    }
}
