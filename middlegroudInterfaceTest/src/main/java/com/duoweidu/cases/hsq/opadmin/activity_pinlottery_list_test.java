package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class activity_pinlottery_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "抽奖活动列表")
    public void activity_pinlottery_list_true() {

        setUrl("activity.pinlottery.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        //list type isAssert isList
        //if 是get list==>不填  post 填list
        //if 返回数据结构是aaData ,则type=2， 不是则不填
        //if 需要断言isAssert == true,不需要 false
        //if data下面有list并加断言判断，则 isList == true ,不需要false
        process(list,2, true, false);

    }
}
