package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class merchant_onlinechat_token_test extends HsqMerchantInterfaceTest {

    //此接口调udesk的，响应时间不受我们控制，故时间设置长点
    @Override
    protected long limitTime() {
        return 10000;
    }

    @Test(groups = "loginTrue",description = "商户平台token")
    public void merchant_onlinechat_token_true() {
        setUrl("merchant.onlinechat.token.uri");
        process();
    }
}
