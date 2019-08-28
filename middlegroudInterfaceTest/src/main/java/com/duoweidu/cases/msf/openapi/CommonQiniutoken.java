package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.CommonQiniutokenData;
import org.testng.annotations.Test;

public class CommonQiniutoken extends MsfInterfaceTest {

    private CommonQiniutokenData model;

    @Test(description = "获取七牛token")
    public void commonQiniutoken() {
        setUrl("common.qiniutoken.uri");
        param = "type=1";
        process(true,false);
        model = sparseJson(CommonQiniutokenData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("upload_url", model.upload_url);
        assertNotEmpty("img_domain", model.img_domain);
        assertNotEmpty("token", model.token);
        assertNotEmpty("deadline", model.deadline);

    }
}
