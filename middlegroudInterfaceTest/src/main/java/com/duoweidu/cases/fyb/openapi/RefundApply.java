package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class RefundApply extends FybInterfaceTest {

    @Test(description = "申请退款")
    public void refundApply() {
        setUrl("refund.apply.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderId", SqlDetail.getParamValue("orderId")));
        list.add(new BasicNameValuePair("refundMethod","1"));
        list.add(new BasicNameValuePair("reasonId","103"));
        process(list,false,false);
    }
}
