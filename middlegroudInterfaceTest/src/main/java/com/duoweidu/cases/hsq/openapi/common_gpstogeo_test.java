package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonGpstogeoData;
import org.testng.annotations.Test;

public class common_gpstogeo_test extends HsqInterfaceTest {

    private CommonGpstogeoData model;

    @Test(description = "获取地理位置信息")
    public void common_gpstogeo_true() {
        setUrl("common.gpstogeo.uri");
        param = "aMapId=021";
        process(true,false);
        model = sparseJson(CommonGpstogeoData.class);
        detailAssert();

    }

    private void detailAssert() {
        detailAssertTest("上海市", "city", model.city);
        detailAssertTest("is_hot", String.valueOf(model.is_hot));
        detailAssertTest("shanghaishi", "pin_yin", model.pin_yin);
        detailAssertTest("上海", "province", model.province);
        detailAssertTest(21, "aMapId", model.aMapId);
        detailAssertTest(857, "zoneId", model.zoneId);
        detailAssertTest(857, "provinceId", model.provinceId);
        detailAssertTest(857, "cityId", model.cityId);
    }

}
