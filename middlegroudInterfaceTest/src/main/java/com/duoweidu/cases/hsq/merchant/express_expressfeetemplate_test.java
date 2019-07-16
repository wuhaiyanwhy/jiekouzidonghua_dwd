package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class express_expressfeetemplate_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "运费模板")
    public void express_expressfeetemplate_true() {
        setUrl("express.expressfeetemplate.uri");
        process();
    }

}
