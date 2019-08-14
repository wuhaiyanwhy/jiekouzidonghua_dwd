package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.UserAddskutocartData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_addskutocart_test extends HsqInterfaceTest {

    private UserAddskutocartData model;

    @Test(dependsOnGroups = "loginTrue",description = "更新购物车商品")
    public void user_addskutocart_true() {
        setUrl("user.addskutocart.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("skuId")));
        list.add(new BasicNameValuePair("amount","1"));
        list.add(new BasicNameValuePair("type","1"));
        list.add(new BasicNameValuePair("price", SqlDetail.getInstance().getParamValue("price")));
        process(list,true,false);
        model = sparseJson(UserAddskutocartData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
        detailAssertTest("behavior", model.behavior);
        detailAssertTest("cartId", model.cartId);
    }
}
