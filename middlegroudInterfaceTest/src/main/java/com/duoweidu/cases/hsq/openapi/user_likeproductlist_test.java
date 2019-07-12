package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;


public class user_likeproductlist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="收藏列表(商品)")
    public void user_likeproductlist_shangpinTrue() {
        setUrl("user.likeproductlist.uri");
        param = "type=1";
        process(true,true);
    }

    @Test(dependsOnGroups = "loginTrue",description ="收藏列表(店铺)")
    public void user_likeproductlist_dianpuTrue() {
        setUrl("user.likeproductlist.uri");
        param = "type=2";
        process(true,true);
    }

}
