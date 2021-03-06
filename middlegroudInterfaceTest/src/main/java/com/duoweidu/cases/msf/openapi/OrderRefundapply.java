package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ResultData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderRefundapply extends MsfInterfaceTest {

    private ResultData model;

    @Test(dependsOnGroups = "loginTrue",description = "退款申请提交接口")
    public void orderRefundapply() {
        setUrl("order.refundapply.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("order_id", SqlDetail.getInstance().getParamValue("order_id")));
        list.add(new BasicNameValuePair("refund_reason_id","1"));
        process(list,true,false);
        model = sparseJson(ResultData.class);
        detailassert();
    }

    private void detailassert() {
        assertEquals("result", model.result, "success");
    }
}
