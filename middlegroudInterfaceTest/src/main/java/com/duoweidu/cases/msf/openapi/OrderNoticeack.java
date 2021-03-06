package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.ResultData;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderNoticeack extends MsfInterfaceTest {

    private ResultData model;

    @Test(dependsOnGroups = "loginTrue",description = "订单列表弹窗提示确认接口")
    public void orderNoticeack() {
        setUrl("order.noticeack.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
        model = sparseJson(ResultData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertEquals("result", model.result, "success");
    }
}
