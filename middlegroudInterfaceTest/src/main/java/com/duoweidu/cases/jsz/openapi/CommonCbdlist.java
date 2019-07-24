package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class CommonCbdlist extends JszInterfaceTest {

    @Test(description = "热门商业圈")
    public void commonCbdlist() {
        setUrl("common.cbdlist.uri");
        param = "zoneId=" + SqlDetail.getInstance().getParamValue(0,"zoneId");
        process(true, false);
    }
}
