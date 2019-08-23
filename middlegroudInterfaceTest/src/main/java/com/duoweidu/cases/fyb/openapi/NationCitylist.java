package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.TraverseConfig;
import com.duoweidu.model.fyb.NationCitylistData;
import org.testng.annotations.Test;

import java.util.Map;

public class NationCitylist extends FybInterfaceTest {

    private NationCitylistData model;

    @Test(description = "获取城市列表")
    public void nationCitylist() {
        setUrl("nation.citylist.uri");
        param = "provinceId=2";
        process(true,true);
        model = sparseJson(NationCitylistData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapList = TraverseConfig.traverseCollection(model.list);
        for (Map.Entry<String, Object> entry:
             mapList.entrySet()) {
            assertNotEmpty(entry.getKey(), entry.getValue());
        }
    }
}
