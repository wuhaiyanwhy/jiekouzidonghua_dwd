package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class activity_pointsku_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝活动管理列表")
    public void activity_pointsku_list_true() {

        setUrl("activity.pointsku.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
