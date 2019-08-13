package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_deletecartsku_test extends HsqInterfaceTest {

    private ResData model;

    @Test(dependsOnGroups = "loginTrue",description = "删除购物车")
    public void user_deletecartsku_true() {
        setUrl("user.deletecartsku.uri");
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("skusInfo",
                "[\n" +
                "  {\n" +
                "    \"skuId\" : " + SqlDetail.getInstance().getParamValue("skuId") + ",\n" +
                "    \"amount\" : \"1\"\n" +
                "  }\n" +
                "]");
        list.add(param1);
        process(list,true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }

}
