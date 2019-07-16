package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.testng.annotations.Test;

public class ZhimaParticipatechange extends HsqInterfaceTest {

    private ResData model;

    @Test(description = "用户合约上报")
    public void zhimaParticipatechange() {
        setUrl("zhima.participatechange.uri");
        param = "token=" + SqlDetail.getInstance().getParamValue("token") +
                "&appId=" + SqlDetail.getInstance().getParamValue(0,"zhimaAppId") +
                "&change=create";
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }}
