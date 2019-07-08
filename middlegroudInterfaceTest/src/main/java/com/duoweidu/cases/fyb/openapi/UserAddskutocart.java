package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserAddskutocart extends FybInterfaceTest {

    @Test(description = "增加用户购物车",groups = "userAddskutocart")
    public void userAddskutocart() {
        setUrl("user.addskutocart.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("price", SqlDetail.getParamValue("price")));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getParamValue("skuId")));
        list.add(new BasicNameValuePair("type","1"));
        list.add(new BasicNameValuePair("amount","1"));
        process(list,true,false);
    }
}
