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

public class OrderRedeem extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "核销/兑换接口")
    public void orderRedeem() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_REDEEM);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("order_id", TestSql.getValue("order_id")));
        list.add(new BasicNameValuePair("redeem_type","1"));
        list.add(new BasicNameValuePair("code",TestSql.getValue("code",2)));
        process(list,false,false);

    }
}
