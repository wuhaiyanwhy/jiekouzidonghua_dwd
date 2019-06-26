package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.InterfaceTest;
import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class Create extends InterfaceTest {

    @Test(description = "创建账户")
    public void create() {
        url = ConfigFileUrl.getUrlByKey("交易中心接口");
        path_id = SqlTradecenter.getTradeCenterPathId("交易中心接口");
        process(true, false);
    }
}
