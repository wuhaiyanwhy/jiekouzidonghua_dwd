package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderNoticepop extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单列表弹窗提示发笔记接口")
    public void orderNoticepop() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_NOTICEPOP);
        process(true,false);

    }
}
