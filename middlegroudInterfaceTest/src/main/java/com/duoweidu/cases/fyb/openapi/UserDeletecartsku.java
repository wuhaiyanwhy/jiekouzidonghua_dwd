package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserDeletecartsku extends FybInterfaceTest {

    @Test(dependsOnGroups = "userGetusercart",description = "删除用户购物车")
    public void userDeletecartsku() {
        setUrl("user.deletecartsku.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skusInfo","[{\"skuId\":"+ SqlDetail.getInstance().getParamValue("skuId") +
                ",\"amount\":1}]"));
        process(list,true,false);
    }
}
