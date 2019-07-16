package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class content_hotsearchsug_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "搜索热词列表")
    public void content_hotsearchsug_list_true() {
        setUrl("content.hotsearchsug.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }
}
