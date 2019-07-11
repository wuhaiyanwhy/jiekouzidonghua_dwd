package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.Interface.ResData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ZhimaParticipatesync extends HsqInterfaceTest {

    private ResData model;

    @Test(description = "用户合约数据同步")
    public void zhimaParticipatesync() {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.ZHIMA_PARTICPATESYNC);
        param = "token=" + SqlDetail.getParamValue("token") +
                "&appId=" + SqlDetail.getParamValue("zhimaAppId", 4);
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }
}
