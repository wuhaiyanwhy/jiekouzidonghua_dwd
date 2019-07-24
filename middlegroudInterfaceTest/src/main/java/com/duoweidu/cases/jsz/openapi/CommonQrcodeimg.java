package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class CommonQrcodeimg extends JszInterfaceTest {

    @Test(description = "二维码")
    public void commonQrcodeimg() {
        setUrl("common.qrcodeimg.uri");
        param = "content=" + SqlDetail.getInstance().getParamValue(0,"content");
        process(false, false);
    }
}
