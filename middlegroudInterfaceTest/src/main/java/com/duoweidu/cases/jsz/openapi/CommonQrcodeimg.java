package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class CommonQrcodeimg extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "二维码")
    public void commonQrcodeimg() {
        setUrl("common.qrcodeimg.uri");
        param = "content=" + SqlDetail.getInstance().getParamValue("content");
        process(false, false);
    }
}
