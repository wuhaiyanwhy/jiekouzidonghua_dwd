package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.UserGetudeskData;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_getudesk_test extends HsqInterfaceTest {
    
    private UserGetudeskData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取udesk信息")
    public void user_getudesk_true() {
        setUrl("user.getudesk.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
        model = sparseJson(UserGetudeskData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("uuid", model.uuid);
        detailAssertTest("timestamp", model.timestamp);
        detailAssertTest("sign", model.sign);
        detailAssertTest("euid", model.euid);
        detailAssertTest("name", model.name);
        detailAssertTest("merchant_id", model.merchant_id);

    }
}
