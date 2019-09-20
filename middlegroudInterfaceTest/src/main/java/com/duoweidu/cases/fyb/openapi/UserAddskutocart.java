package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.fyb.UserAddskutocartData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserAddskutocart extends FybInterfaceTest {

    private UserAddskutocartData model;

    @Test(description = "增加用户购物车",groups = "userAddskutocart")
    public void userAddskutocart() {
        setUrl("user.addskutocart.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("price", SqlDetail.getInstance().getParamValue("price")));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("skuId")));
        list.add(new BasicNameValuePair("type","1"));
        list.add(new BasicNameValuePair("amount","1"));
        process(list,true,false);
        model = sparseJson(UserAddskutocartData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertTrue("res", model.res);
        assertNotEmpty("behavior", model.behavior);
    }
}
