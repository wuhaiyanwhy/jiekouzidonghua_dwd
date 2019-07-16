package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class activity_pointwao_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝链接管理地址配置管理列表")
    public void activity_pointwao_list_true() {

        setUrl("activity.pointwao.list.uri");
        process(2,true,false);

    }
}
