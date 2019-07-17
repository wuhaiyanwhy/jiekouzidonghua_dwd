package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderOrderdetail extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "订单详情")
    public void orderOrderdetail() {
        setUrl("order.orderlist.uri");
        List<NameValuePair> list = new LinkedList<>();
        param = "id=" + SqlDetail.getInstance().getParamValue("id");
        process(true, false);
    }
}
