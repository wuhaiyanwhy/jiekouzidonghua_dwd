package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_userorderconfirm_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "确认收货")
    public void order_userorderconfirm_pintuanTrue() {
        setUrl("order.userorderconfirm.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderId", SqlDetail.getInstance().getParamValue("orderId")));
        process(list,false,false);
    }

}
