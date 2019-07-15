package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class activity_pinlotteryonline_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "抽奖团管理列表")
    public void activity_pinlotteryonline_list_true() {

        setUrl("activity.pinlotteryonline.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
