package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class refund_apply_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "申请退款")
    public void refund_apply_true() {
        setUrl("refund.apply.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderId", SqlDetail.getParamValue("orderId")));
        list.add(new BasicNameValuePair("refundMethod","1"));
        list.add(new BasicNameValuePair("reasonId","103"));
        process(false,false);
    }
}
