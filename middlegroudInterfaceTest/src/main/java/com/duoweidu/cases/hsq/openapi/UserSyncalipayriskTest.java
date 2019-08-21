package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.testng.annotations.Test;

public class UserSyncalipayriskTest extends HsqInterfaceTest {

    private ResData model;

    //传appid需要找第三方加权限
    @Test(description = "用户Riskgo评分回传-营销反作弊-拼团")
    public void userSyncalipayriskGroup() {
        commonParameters(SqlDetail.getInstance().getParamValue(0,"pinAppId"));
    }

    @Test(description = "用户Riskgo评分回传-营销反作弊-积分")
    public void userSyncalipayriskPoint() {
        commonParameters(SqlDetail.getInstance().getParamValue(0,"pointAppId"));
    }

    public void commonParameters(String appId) {
        setUrl("user.syncalipayrisk.uri");
        param = "token=" + SqlDetail.getInstance().getParamValue("point_token")
                + "&rank=rank4&processCode=16&appId=" + appId;
        process(true, false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertTrue("res",  model.res);
    }
}
