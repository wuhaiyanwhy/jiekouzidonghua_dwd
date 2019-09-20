package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.utils.TraverseResult;
import com.duoweidu.model.fyb.UserVouchercenterData;
import org.testng.annotations.Test;

import java.util.Map;

public class UserVouchercenter extends FybInterfaceTest {

    private UserVouchercenterData model;

    @Test(description = "用户代金券首页")
    public void userVouchercenter() {
        setUrl("user.vouchercenter.uri");
        process(true,false);
        model = sparseJson(UserVouchercenterData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseResult.traverseObj(model);
        for (Map.Entry<String, Object> entry:
             mapData.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
    }
}
