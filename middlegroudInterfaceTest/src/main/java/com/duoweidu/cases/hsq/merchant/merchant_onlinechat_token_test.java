package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import org.testng.annotations.Test;

public class merchant_onlinechat_token_test extends HsqMerchantInterfaceTest {

    @Test(groups = "loginTrue",description = "商户平台token")
    public void merchant_onlinechat_token_true() {
        setUrl("merchant.onlinechat.token.uri");
        process();
    }
}
