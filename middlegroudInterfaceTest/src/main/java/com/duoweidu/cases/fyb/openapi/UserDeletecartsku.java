package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserDeletecartsku extends FybInterfaceTest {

    private ResData model;

    @Test(dependsOnGroups = "userGetusercart", description = "删除用户购物车", groups = "userDeletecartsku")
    public void userDeletecartsku() {
        setUrl("user.deletecartsku.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skusInfo","[{\"skuId\":"+ SqlDetail.getInstance().getParamValue("skuId") +
                ",\"amount\":1}]"));
        process(list,true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertTrue("res", model.res);
    }
}
