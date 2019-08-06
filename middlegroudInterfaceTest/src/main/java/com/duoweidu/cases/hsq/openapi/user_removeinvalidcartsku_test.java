package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_removeinvalidcartsku_test extends HsqInterfaceTest {
    @Test(dependsOnGroups = "addskutocart", description = "清空失效商品")
    public void user_removeinvalidcartsku_true(){
        setUrl("user.removeinvalidcartsku.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("Content-Type", SqlDetail.getInstance().getParamValue(0,"Content-Type")));
        process(list,true,false);
    }

}
