package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OrderRefundapply extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "退款申请提交接口")
    public void orderRefundapply() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_REFUNDAPPLY);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("order_id", TestSql.getValue("order_id")));
        list.add(new BasicNameValuePair("refund_reason_id","1"));
        process(list,true,false);
    }
}
