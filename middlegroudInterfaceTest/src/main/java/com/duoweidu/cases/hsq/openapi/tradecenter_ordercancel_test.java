package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 无法一直取消，暂时无需详细断言
 */
public class tradecenter_ordercancel_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "积分取消订单")
    public void tradecenter_ordercancel_true() {
        setUrl("tradecenter.ordercancel.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderId", SqlDetail.getInstance().getParamValue("orderId")));
        list.add(new BasicNameValuePair("reason","1"));
        list.add(new BasicNameValuePair("reasonId","1"));
        process(false,false);
    }
}
