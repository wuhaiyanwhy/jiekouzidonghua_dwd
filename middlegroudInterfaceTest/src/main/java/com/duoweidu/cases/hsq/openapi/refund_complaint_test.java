package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 无法一直申诉，暂时无需详细断言
 */
public class refund_complaint_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "退款申诉")
    public void refund_complaint_true() {
        setUrl("refund.complaint.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("refundOrderId","1003801"));
        process(list,false,false);
    }
}
