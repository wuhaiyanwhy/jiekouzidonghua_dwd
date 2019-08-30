package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.utils.TraverseResult;
import com.duoweidu.model.fyb.UserGetuserinviteinfoData;
import org.testng.annotations.Test;

import java.util.Map;

public class UserGetuserinviteinfo extends FybInterfaceTest {

    private UserGetuserinviteinfoData model;

    @Test(description = "赚红包")
    public void userGetuserinviteinfo() {
        setUrl("user.getuserinviteinfo.uri");
        param = "needPagination=1&pageNum=1&pageLimit=10";
        process(true,false);
        model = sparseJson(UserGetuserinviteinfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseResult.traverseObj(model);
        Map<String, Object> mapUserInfo = TraverseResult.traverseObj(model.userInfo);

        for (Map.Entry<String, Object> entry:
             mapData.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapUserInfo.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
    }
}
