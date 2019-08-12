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

    }

    private void detailAssertStore() {
    }

}
