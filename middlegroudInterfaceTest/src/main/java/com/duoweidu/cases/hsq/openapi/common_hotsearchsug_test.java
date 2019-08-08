package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonHotsearchsugData;
import org.testng.annotations.Test;

public class common_hotsearchsug_test extends HsqInterfaceTest {

    private CommonHotsearchsugData model;

    @Test(description = "搜索热词")
    public void common_hotsearchsug_true() {
        setUrl("common.hotsearchsug.uri");
        process(true,true);
        model = sparseJson(CommonHotsearchsugData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).value", model.list.get(i).value);
            detailAssertTest("list.get(i).priority", model.list.get(i).priority);
            detailAssertTest("list.get(i).searchCnt", String.valueOf(model.list.get(i).searchCnt));
//            detailAssertTest("list.get(i).url", model.list.get(i).url);
            detailAssertTest("list.get(i).type", model.list.get(i).type);
        }
    }

}
