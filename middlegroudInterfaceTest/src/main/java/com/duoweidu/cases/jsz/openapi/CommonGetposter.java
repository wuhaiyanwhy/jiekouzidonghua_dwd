package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class CommonGetposter extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "获取分享海报")
    public void commonGetposter() {
        setUrl("common.getposter.uri");
        param = "qrCnt=" + SqlDetail.getInstance().getParamValue("qrCnt") +
                "&title=" + SqlDetail.getInstance().getParamValue("title") +
                "&picUrl=" + SqlDetail.getInstance().getParamValue("picUrl") +
                "&salePrice=" + SqlDetail.getInstance().getParamValue("salePrice") +
                "&marketPrice=" + SqlDetail.getInstance().getParamValue("marketPrice");
        process(false, false);
    }
}
