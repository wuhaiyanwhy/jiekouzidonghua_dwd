package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_recommendactive_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动商品推荐")
    public void content_recommendactive_index_true() {

        setUrl("content.recommendactive.index.uri");
        process(false,false);

    }
}
