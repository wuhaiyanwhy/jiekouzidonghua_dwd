package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 无法实际核销，暂时无需详细断言
 */
public class OrderRedeem extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "核销/兑换接口")
    public void orderRedeem() {
        setUrl("order.redeem.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("order_id", SqlDetail.getInstance().getParamValue("order_id")));
        list.add(new BasicNameValuePair("redeem_type","1"));
        list.add(new BasicNameValuePair("code",SqlDetail.getInstance().getParamValue(2, "code")));
        process(list,false,false);

    }
}
