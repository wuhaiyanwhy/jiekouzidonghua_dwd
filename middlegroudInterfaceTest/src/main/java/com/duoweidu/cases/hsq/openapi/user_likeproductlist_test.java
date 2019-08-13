package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.UserLikeproductlistData;
import org.testng.annotations.Test;


public class user_likeproductlist_test extends HsqInterfaceTest {

    private UserLikeproductlistData model;

    private void genLikeproductlist(int type) {
        setUrl("user.likeproductlist.uri");
        param = "type=" + type;
        process(true,true);
        model = sparseJson(UserLikeproductlistData.class);
    }

    @Test(dependsOnGroups = "loginTrue",description ="收藏列表(商品)")
    public void user_likeproductlist_shangpinTrue() {
        genLikeproductlist(1);
        detailAssertGoods();
    }

    @Test(dependsOnGroups = "loginTrue",description ="收藏列表(店铺)")
    public void user_likeproductlist_dianpuTrue() {
        genLikeproductlist(2);
        detailAssertStore();
    }

    private void detailAssertGoods() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).source_type", model.list.get(i).source_type);
            detailAssertTest("list.get(i).user_id", model.list.get(i).user_id);
            detailAssertTest("list.get(i).product_id", model.list.get(i).product_id);
            detailAssertTest("list.get(i).sku_id", model.list.get(i).sku_id);
            detailAssertTest("list.get(i).product_name", model.list.get(i).product_name);
            detailAssertTest("list.get(i).thumbnail", model.list.get(i).thumbnail);
            detailAssertTest("list.get(i).delete_flag", String.valueOf(model.list.get(i).delete_flag));
            detailAssertTest("list.get(i).created_at", model.list.get(i).created_at);
            detailAssertTest("list.get(i).skuId", model.list.get(i).skuId);
            detailAssertTest("list.get(i).sourceType", model.list.get(i).sourceType);
            detailAssertTest("list.get(i).schema", model.list.get(i).schema);
            detailAssertTest("list.get(i).offline_before_expired", model.list.get(i).offline_before_expired);
            detailAssertTest("list.get(i).left_stock", String.valueOf(model.list.get(i).left_stock));
            detailAssertTest("list.get(i).produce_price", model.list.get(i).produce_price);
            detailAssertTest("list.get(i).price", model.list.get(i).price);
            detailAssertTest("list.get(i).lowest_price", model.list.get(i).lowest_price);
            detailAssertTest("list.get(i).seller_time", model.list.get(i).seller_time);
            detailAssertTest("list.get(i).expired_date", model.list.get(i).expired_date);
            detailAssertTest("list.get(i).market_price", model.list.get(i).market_price);

        }
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("totalCnt", model.totalCnt);

    }

    private void detailAssertStore() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).user_id", model.list.get(i).user_id);
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).sourceType", model.list.get(i).sourceType);
            detailAssertTest("list.get(i).logo", model.list.get(i).logo);
            detailAssertTest("list.get(i).name", model.list.get(i).name);
            detailAssertTest("list.get(i).created_at", model.list.get(i).created_at);
            detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("list.get(i).schema", model.list.get(i).schema);
            detailAssertTest("list.get(i).city", model.list.get(i).city);
            detailAssertTest("list.get(i).province", model.list.get(i).province);
        }
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("totalCnt", model.totalCnt);

    }

}
