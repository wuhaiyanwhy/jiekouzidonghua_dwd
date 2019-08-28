package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.CommonOpenimData;
import org.testng.annotations.Test;

public class CommonOpenim extends MsfInterfaceTest {

    private CommonOpenimData model;

    @Test(description = "获取Udesk参数")
    public void commonOpenim() {
        setUrl("common.openim.uri");
        process(true,false);
        model = sparseJson(CommonOpenimData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("nonce", model.nonce);
        assertNotEmpty("timestamp", model.timestamp);
        assertNotEmpty("web_token", model.web_token);
        assertNotEmpty("signature", model.signature);

    }
}
