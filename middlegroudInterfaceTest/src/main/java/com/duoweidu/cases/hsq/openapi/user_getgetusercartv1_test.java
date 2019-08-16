package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.UserGetgetusercartv1Data;
import org.testng.annotations.Test;

public class user_getgetusercartv1_test extends HsqInterfaceTest {

    private UserGetgetusercartv1Data model;

    @Test(dependsOnGroups = "addskutocart", description = "购物车页面")
    public void user_getgetusercartv1_true(){
        setUrl("user.getusercartv1.uri");
        process(true,true);
        model = sparseJson(UserGetgetusercartv1Data.class);
        detailAssert();
    }

    private void detailAssert() {

        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("list.get(i).merchant_name", model.list.get(i).merchant_name);
            detailAssertTest("list.get(i).merchant_url", model.list.get(i).merchant_url);
            detailAssertTest("list.get(i).icon", model.list.get(i).icon);
            detailAssertTest("list.get(i).sku_list", model.list.get(i).sku_list);
            for (int j = 0; j < model.list.get(i).sku_list.size(); j++) {
                detailAssertTest("list.get(i).sku_list.get(j).id", model.list.get(i).sku_list.get(j).id);
                detailAssertTest("list.get(i).sku_list.get(j).sku_id", model.list.get(i).sku_list.get(j).sku_id);
                detailAssertTest("list.get(i).sku_list.get(j).name", model.list.get(i).sku_list.get(j).name);
                detailAssertTest("list.get(i).sku_list.get(j).merchant_type", model.list.get(i).sku_list.get(j).merchant_type);
                detailAssertTest("list.get(i).sku_list.get(j).pic", model.list.get(i).sku_list.get(j).pic);
                detailAssertTest("list.get(i).sku_list.get(j).attrs", model.list.get(i).sku_list.get(j).attrs);
                detailAssertTest("list.get(i).sku_list.get(j).price", model.list.get(i).sku_list.get(j).price);
                detailAssertTest("list.get(i).sku_list.get(j).amount", model.list.get(i).sku_list.get(j).amount);
                detailAssertTest("list.get(i).sku_list.get(j).is_like", String.valueOf(model.list.get(i).sku_list.get(j).is_like));
                detailAssertTest("list.get(i).sku_list.get(j).max_cart_nums", model.list.get(i).sku_list.get(j).max_cart_nums);
                detailAssertTest("list.get(i).sku_list.get(j).left_stock", model.list.get(i).sku_list.get(j).left_stock);
                detailAssertTest("list.get(i).sku_list.get(j).active", model.list.get(i).sku_list.get(j).active);
            }
        }
        detailAssertTest("cart_jump_url", model.cart_jump_url);
        detailAssertTest("single_sku_cnt", model.single_sku_cnt);
        detailAssertTest("total_sku_cnt", model.total_sku_cnt);

    }
}
