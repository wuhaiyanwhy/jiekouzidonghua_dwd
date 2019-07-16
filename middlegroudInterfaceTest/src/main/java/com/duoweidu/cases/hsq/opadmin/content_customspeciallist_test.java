package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class content_customspeciallist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "自定义专题列表")
    public void content_customspeciallist_true() {

        setUrl("content.customspeciallist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
