package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderOrderlist extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "提交订单")
    public void orderOrderlist() {
        setUrl("order.orderlist.uri");
        List<NameValuePair> list = new LinkedList<>();
        param = "status=" + SqlDetail.getInstance().getParamValue("status");
        process(true, false);
    }
}
