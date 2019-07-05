package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class OrderTypeToComment extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "待评论订单")
    public void order_type_to_comment_true() {
        setUrl("order.type.to_comment.uri");
        process(false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertStatus();
        }
    }
}
