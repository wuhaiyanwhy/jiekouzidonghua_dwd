package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class ugc_ugclist_openapi_test extends HsqInterfaceTest {

        @Test(dependsOnGroups = "loginTrue",description = "获取单品评论列表")
        public void ugc_ugclist_openapi_true() {
            setUrl("ugc.ugclist.openapi.uri");
            param = "skuId=" + SqlDetail.getParamValue("skuId");
            process(true,false);
        }
}
