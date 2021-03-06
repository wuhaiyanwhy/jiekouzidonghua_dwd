package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 无法一直申请退款，暂时无需详细断言
 */
public class refund_apply_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "申请退款")
    public void refund_apply_true() {
        setUrl("refund.apply.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderId", SqlDetail.getInstance().getParamValue("orderId")));
        list.add(new BasicNameValuePair("refundMethod","1"));
        list.add(new BasicNameValuePair("reasonId","103"));
        process(list, false,false);
    }
}
