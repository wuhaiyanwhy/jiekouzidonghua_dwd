package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ugc_ugclist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "评论审核列表")
    public void ugc_ugclist_true() {

        setUrl("ugc.ugclist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list);

    }
}
