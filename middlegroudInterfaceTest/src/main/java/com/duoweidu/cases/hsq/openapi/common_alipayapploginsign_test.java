package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonAlipayapploginsignData;
import org.testng.annotations.Test;

public class common_alipayapploginsign_test extends HsqInterfaceTest {

    private CommonAlipayapploginsignData model;

    @Test(description = "支付宝登录密钥")
    public void common_alipayapploginsign_true() {
        setUrl("common.alipayapploginsign.uri");
        process(true,false);
        model = sparseJson(CommonAlipayapploginsignData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("singString", model.singString);
    }


}
