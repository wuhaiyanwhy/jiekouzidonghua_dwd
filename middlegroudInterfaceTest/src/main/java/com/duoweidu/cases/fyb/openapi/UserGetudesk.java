package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.utils.TraverseResult;
import com.duoweidu.model.fyb.UserGetudeskData;
import org.testng.annotations.Test;

import java.util.Map;

public class UserGetudesk extends FybInterfaceTest {

    private UserGetudeskData model;

    @Test(description = "udesk")
    public void userGetudesk() {
        setUrl("user.getudesk.uri");
        process(true,false);
        model = sparseJson(UserGetudeskData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseResult.traverseObj(model);
        for (Map.Entry<String,Object> entry:
             mapData.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
    }
}
