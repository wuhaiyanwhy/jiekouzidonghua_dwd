package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class product_selectcategory_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "发布新商品")
    public void product_selectcategory_true() {
        setUrl("product.selectcategory.uri");
        process();
    }

}
