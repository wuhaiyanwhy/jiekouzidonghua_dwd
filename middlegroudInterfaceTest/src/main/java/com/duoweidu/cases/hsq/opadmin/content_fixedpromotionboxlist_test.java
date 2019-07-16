package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class content_fixedpromotionboxlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "固定推广位列表")
    public void content_fixedpromotionboxlist_true() {

        setUrl("content.fixedpromotionboxlist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);

    }
}
