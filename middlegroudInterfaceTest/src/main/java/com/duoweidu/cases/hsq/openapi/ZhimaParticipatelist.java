package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ZhimaParticipatelist extends HsqInterfaceTest {

    @Test(description = "我的合约列表")
    public void zhimaParticipatelist() {
        setUrl("zhima.participatelist.uri");
        param = "token=" + SqlDetail.getParamValue("token");
        process(true,false);
    }
}
