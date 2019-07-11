package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.Interface.ResData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ZhimaParticipatechange extends HsqInterfaceTest {

    private ResData model;

    @Test(description = "用户合约上报")
    public void zhimaParticipatechange() {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.ZHIMA_PARTICIPATECHANGE);
        param = "token=" + SqlDetail.getParamValue("token") +
                "&appId=" + SqlDetail.getParamValue("zhimaAppId", 4) +
                "&change=create";
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }}
