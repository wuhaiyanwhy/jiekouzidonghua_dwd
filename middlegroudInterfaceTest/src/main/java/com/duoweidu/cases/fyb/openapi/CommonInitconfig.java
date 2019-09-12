package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.utils.TraverseResult;
import com.duoweidu.model.fyb.CommonInitconfigData;
import org.testng.annotations.Test;

import java.util.Map;

public class CommonInitconfig extends FybInterfaceTest {

    private CommonInitconfigData model;

    @Test(description = "初始化配置")
    public void commonInitconfig() {
        setUrl("common.initconfig.uri");
        process(true,false);
        model = sparseJson(CommonInitconfigData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseResult.traverseObj(model);
        Map<String, Object> mapVoucherRule = TraverseResult.traverseObj(model.voucherRule);
        for (Map.Entry<String, Object> entry:
        mapData.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapVoucherRule.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
    }
}
