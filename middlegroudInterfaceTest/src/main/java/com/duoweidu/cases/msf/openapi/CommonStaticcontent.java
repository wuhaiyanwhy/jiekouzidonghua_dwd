package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.CommonStaticcontentData;
import org.testng.annotations.Test;

public class CommonStaticcontent extends MsfInterfaceTest {

    private CommonStaticcontentData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取静态页内容（用户协议）")
    public void commonStaticcontent() {
        setUrl("common.staticcontent.uri");
        param = "q=terms_of_privacy";
        process(true,false);
        model = sparseJson(CommonStaticcontentData.class);
        detailassert();
    }

    private void detailassert() {
        assertNotEmpty("url", model.url);
        assertNotNull("content", model.content);

    }
}
