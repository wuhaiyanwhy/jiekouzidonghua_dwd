package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.iqg.AppconfigData;
import org.testng.annotations.Test;

public class Appconfig extends IqgInterfaceTest {

    private AppconfigData model;

    @Test(dependsOnGroups = "loginTrue",description = "配置")
    public void appconfig_true() {
        setUrl("appconfig.uri");
        param = "platform=1";
        process(true,false);
        model = sparseJson(AppconfigData.class);
        detailAssert();
    }

    private void detailAssert(){
        detailAssertTest("offline_log_url",model.config.offline_log_url);

    }
}
