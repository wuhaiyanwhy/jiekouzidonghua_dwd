package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_deletecartsku_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "删除购物车")
    public void user_deletecartsku_true() {
        setUrl("user.deletecartsku.uri");
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("skusInfo",
                "[\n" +
                "  {\n" +
                "    \"skuId\" : " + SqlDetail.getParamValue("skuId") + ",\n" +
                "    \"amount\" : \"1\"\n" +
                "  }\n" +
                "]");
        list.add(param1);
        process(list,true,false);
    }

}
