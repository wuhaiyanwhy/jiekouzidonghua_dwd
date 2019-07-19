package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.testng.annotations.Test;

public class CommonWxsign extends JszInterfaceTest {

    @Test(description = "微信jsapi_ticket签名")
    public void commonWxsign() {
        setUrl("common.wxsign.uri");
//        param = "appId=" + SqlDetail.getInstance().getParamValue(0, "appId");
//        param = "url=" + SqlDetail.getInstance().getParamValue(2, "url");
        process(false, false);
    }
}
