package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.UserRiskpreventcheatData;
import org.testng.annotations.Test;

public class UserRiskpreventcheat extends HsqInterfaceTest {

    private UserRiskpreventcheatData model;

    @Test(description = "风险预防反作弊")
    public void userRiskpreventcheat() {
        setUrl("user.riskpreventcheat.uri");
        param = "token=" + SqlDetail.getInstance().getParamValue("point_token");
        process(true);
        model = sparseJson(UserRiskpreventcheatData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotNull("pid", model.pid);
        assertNotNull("app_id", model.app_id);
        assertNotNull("biz_context.service", model.biz_context.service);
        assertNotNull("biz_context.risk_type", model.biz_context.risk_type);
        assertNotNull("biz_context.pid", model.biz_context.pid);


    }
}
