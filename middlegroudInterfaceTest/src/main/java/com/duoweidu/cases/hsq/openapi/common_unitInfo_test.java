package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonUnitInfoData;
import org.testng.annotations.Test;

public class common_unitInfo_test extends HsqInterfaceTest {

    private CommonUnitInfoData model;

    @Test(description = "检测组件包更新")
    public void common_unitInfo_true() {
        setUrl("common.unitInfo.uri");
        process(true,false);
        model = sparseJson(CommonUnitInfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("packages", model.packages);
        if (model.packages.size() > 0) {
            for (int i = 0; i < model.packages.size(); i++) {
                detailAssertTest("packages.get(i).id", model.packages.get(i).id);
                detailAssertTest("packages.get(i).version", model.packages.get(i).version);
                detailAssertTest("packages.get(i).url", model.packages.get(i).url);
                detailAssertTest("packages.get(i).type", model.packages.get(i).type);
            }
        }
    }
}
