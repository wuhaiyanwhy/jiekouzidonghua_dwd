package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.TraverseConfig;
import com.duoweidu.model.fyb.CommonHotsearchsugData;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CommonHotsearchsug extends FybInterfaceTest {

    private CommonHotsearchsugData model;

    @Test(description = "商品推荐词")
    public void commonHotsearchsug() {
        setUrl("common.hotsearchsug.uri");
        process(true,false);
//        model = sparseJson(CommonHotsearchsugData.class);
//        detailAssert();
    }

    private void detailAssert() {

        Map<String, Object> mapList = TraverseConfig.traverseCollection(model.list);
        for (Map.Entry<String, Object> entry:
             mapList.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
    }
}
