package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.UserEditcartskuData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserEditcartsku extends HsqInterfaceTest {

    private UserEditcartskuData model;

    @Test(dependsOnGroups = "addskutocart", description = "编辑购物车")
    public void userEditcartsku(){
        setUrl("user.editcartsku.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("Content-Type", SqlDetail.getInstance().getParamValue(0,"Content-Type")));
        list.add(new BasicNameValuePair("skuId",SqlDetail.getInstance().getParamValue("goskuId")));
        list.add(new BasicNameValuePair("newSkuId",SqlDetail.getInstance().getParamValue("gonewskuId")));
        list.add(new BasicNameValuePair("amount",SqlDetail.getInstance().getParamValue("gonewamount")));
        process(list,true,false);
        model = sparseJson(UserEditcartskuData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("type", model.type);
        detailAssertTest("item.id", model.item.id);
        detailAssertTest("item.sku_id", model.item.sku_id);
        detailAssertTest("item.name", model.item.name);
        detailAssertTest("item.pic", model.item.pic);
        detailAssertTest("item.attrs", model.item.attrs);
        detailAssertTest("item.price", model.item.price);
        detailAssertTest("item.amount", model.item.amount);
        detailAssertTest("item.max_cart_nums", model.item.max_cart_nums);
        detailAssertTest("item.active", model.item.active);

    }


}
