package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class activity_pinlottery_winnerlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "抽奖活动winnerList")
    public void activity_pinlottery_winnerlist_true() {

        setUrl("activity.pinlottery.winnerlist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);

    }
}
