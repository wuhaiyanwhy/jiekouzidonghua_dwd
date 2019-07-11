package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_addskutocart_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新购物车商品")
    public void user_addskutocart_true() {
        setUrl("user.addskutocart.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skuId", SqlDetail.getParamValue("skuId")));
        list.add(new BasicNameValuePair("amount","1"));
        list.add(new BasicNameValuePair("type","1"));
        list.add(new BasicNameValuePair("price", SqlDetail.getParamValue("price")));
        process(list,true,false);
    }
}
