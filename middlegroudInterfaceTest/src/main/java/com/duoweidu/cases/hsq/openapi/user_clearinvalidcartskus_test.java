package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 只能清空一次，暂时无需通用断言
 */
public class user_clearinvalidcartskus_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "清空购物车失效商品")
    public void user_clearinvalidcartskus_true() {
        setUrl("user.clearinvalidcartskus.uri");
        List<NameValuePair> list = new LinkedList<>();
        //只能清空一次
//        BasicNameValuePair param1 = new BasicNameValuePair("userId","23391594");
//        list.add(param1);
        process(list,false,false);
    }
}
