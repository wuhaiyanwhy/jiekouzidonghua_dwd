package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.testng.annotations.Test;

public class ZhimaParticipatesync extends HsqInterfaceTest {

    private ResData model;

    @Test(description = "用户合约数据同步")
    public void zhimaParticipatesync() {
        setUrl("zhima.participatesync.uri");
        param = "token=" + SqlDetail.getParamValue("token") +
                "&appId=" + SqlDetail.getParamValue(0,"zhimaAppId");
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }
}
