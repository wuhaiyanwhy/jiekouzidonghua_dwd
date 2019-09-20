package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CoinExchange extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "金币兑换")
    public void coin_exchange_true() {
        setUrl("coin.exchange.uri");
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("id","1");
        list.add(param1);
        process(list,false,false);
        generalAssertStatus();
    }
}
