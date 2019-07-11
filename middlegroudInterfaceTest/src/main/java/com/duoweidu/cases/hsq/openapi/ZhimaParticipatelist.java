package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ZhimaParticipatelist extends HsqInterfaceTest {

    @Test(description = "我的合约列表")
    public void zhimaParticipatelist() {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.ZHIMA_PARTICIPATELIST);
        param = "token=" + SqlDetail.getParamValue("token");
        process(true,false);
    }
}
