package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class product_selfrecommendlist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "个人中心推荐商品")
    public void product_selfrecommendlist_true() {
        setUrl("product.selfrecommendlist.uri");
        param = "pageLimit=20&pageNum=1";
        process(true,true);
    }
}
