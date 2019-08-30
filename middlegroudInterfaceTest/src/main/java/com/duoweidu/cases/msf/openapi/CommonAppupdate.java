package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.CommonAppupdateData;
import com.duoweidu.utils.TraverseResult;
import org.testng.annotations.Test;

import java.util.Map;

public class CommonAppupdate extends MsfInterfaceTest {

    private CommonAppupdateData model;

    @Test(description = "app更新")
    public void commonAppupdate() {
        setUrl("common.appupdate.uri");
        process(true,false);
        model = sparseJson(CommonAppupdateData.class);
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
