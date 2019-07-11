package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class user_likeproductlist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="收藏列表(商品)")
    public void user_likeproductlist_shangpinTrue() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_LIKEPRODUCTLIST);
        param = "type=1";
        process(true,true);
    }

    @Test(dependsOnGroups = "loginTrue",description ="收藏列表(店铺)")
    public void user_likeproductlist_dianpuTrue() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_LIKEPRODUCTLIST);
        param = "type=2";
        process(true,true);
    }

}
