package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserEditcartsku extends HsqInterfaceTest {
    @Test(dependsOnGroups = "addskutocart",description = "编辑购物车",priority = 2)
    public void userEditcartsku(){
        setUrl("user.editcartsku.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("Content-Type", SqlDetail.getInstance().getParamValue(0,"Content-Type")));
        list.add(new BasicNameValuePair("skuId",SqlDetail.getInstance().getParamValue("goskuId")));
        list.add(new BasicNameValuePair("newSkuId",SqlDetail.getInstance().getParamValue("gonewskuId")));
        list.add(new BasicNameValuePair("amount",SqlDetail.getInstance().getParamValue("gonewamount")));
        process(list,true,false);
    }
}
