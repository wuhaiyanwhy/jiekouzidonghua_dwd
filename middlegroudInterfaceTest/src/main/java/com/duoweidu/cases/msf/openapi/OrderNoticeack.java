package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OrderNoticeack extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单列表弹窗提示确认接口")
    public void orderNoticeack() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_NOTICEACK);
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }
}
