package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

/**
 * 无评论数据，暂时无需通用断言
 */
public class ugc_ugclist_openapi_test extends HsqInterfaceTest {

        @Test(dependsOnGroups = "loginTrue",description = "获取单品评论列表")
        public void ugc_ugclist_openapi_true() {
            setUrl("ugc.ugclist.openapi.uri");
            param = "skuId=" + SqlDetail.getInstance().getParamValue("skuId");
            process(true,false);
        }
}
