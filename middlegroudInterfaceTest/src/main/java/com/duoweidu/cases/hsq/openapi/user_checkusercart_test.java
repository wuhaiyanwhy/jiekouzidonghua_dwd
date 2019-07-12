package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_checkusercart_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "检查购物车是否合法")
    public void user_checkusercart_true() {
        setUrl("user.checkusercart.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skuId", SqlDetail.getParamValue("skuId")));
        list.add(new BasicNameValuePair("amount","1"));
        process(list,false,false);
        generalAssertTest();
    }

}
