package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class activity_pointwao_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝链接地址配置管理")
    public void activity_pointwao_index_true() {

        setUrl("activity.pointwao.index.uri");
        process(false,false);

    }
}
