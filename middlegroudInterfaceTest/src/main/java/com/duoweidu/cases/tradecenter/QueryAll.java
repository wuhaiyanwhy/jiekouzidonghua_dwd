package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class QueryAll extends TradeCenterInterfaceTest {

    @Test(dependsOnGroups = "msfCreate", description = "查询用户名下所有用户")
    public void msfQueryAll() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method","account.query_all"));
        list.add(new BasicNameValuePair("pageNum","1"));
        list.add(new BasicNameValuePair("pageSize","10"));
        list.add(new BasicNameValuePair("where","{\"account_type_code\":{\"eq\":\"DWD_IQG_COIN\"}}"));
        list.add(new BasicNameValuePair("order","{\"id\":\"asc\"}"));
        process(list, true, false);
    }
}
