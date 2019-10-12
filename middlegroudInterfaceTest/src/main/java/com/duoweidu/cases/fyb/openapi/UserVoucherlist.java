package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.utils.TraverseResult;
import com.duoweidu.model.fyb.UserVoucherlistData;
import org.testng.annotations.Test;

import java.util.Map;

public class UserVoucherlist extends FybInterfaceTest {

    private UserVoucherlistData model;

    @Test(description = "用户代金券列表")
    public void userVoucherlist() {
        setUrl("user.voucherlist.uri");
        param = "needPagination=1&pageNum=1&pageLimit=10";
        process(true,true);
        model = sparseJson(UserVoucherlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseResult.traverseObj(model);
        Map<String, Object> mapList = TraverseResult.traverseObj(model.list);
        for (Map.Entry<String, Object> entry:
             mapData.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapList.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
    }
}
