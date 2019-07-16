package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderUserorderconfirm extends FybInterfaceTest {

    @Test(description = "确认收货")
    public void orderUserorderconfirm() {
        setUrl("order.userorderconfirm.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderId", SqlDetail.getInstance().getParamValue("orderId")));
        process(list,false,false);
    }
}
