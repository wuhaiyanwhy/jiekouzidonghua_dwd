package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonTopnavigatelistData;
import org.testng.annotations.Test;

public class common_topnavigatelist_test extends HsqInterfaceTest {

    private CommonTopnavigatelistData model;

    @Test(description = "首页导航栏")
    public void common_topnavigatelist_true() {
        setUrl("common.topnavigatelist.uri");
        param = "sourceType=1";
        process(true,false);
        model = sparseJson(CommonTopnavigatelistData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("topNavigateList", model.topNavigateList);
        for (int i = 0; i < model.topNavigateList.size(); i++) {
            detailAssertTest("topNavigateList.get(i).id", model.topNavigateList.get(i).id);
            detailAssertTest("topNavigateList.get(i).source_type", model.topNavigateList.get(i).source_type);
            detailAssertTest("topNavigateList.get(i).type", model.topNavigateList.get(i).type);
//            detailAssertTest("topNavigateList.get(i).icon", model.topNavigateList.get(i).icon);
            detailAssertTest("topNavigateList.get(i).label", model.topNavigateList.get(i).label);
            detailAssertTest("topNavigateList.get(i).jump_type", model.topNavigateList.get(i).jump_type);
            detailAssertTest("topNavigateList.get(i).jump_url", model.topNavigateList.get(i).jump_url);
            detailAssertTest("topNavigateList.get(i).client_type", String.valueOf(model.topNavigateList.get(i).client_type));
            detailAssertTest("topNavigateList.get(i).priority", String.valueOf(model.topNavigateList.get(i).priority));
            detailAssertTest("topNavigateList.get(i).enabled", model.topNavigateList.get(i).enabled);
            detailAssertTest("topNavigateList.get(i).version", model.topNavigateList.get(i).version);
        }

    }

}
