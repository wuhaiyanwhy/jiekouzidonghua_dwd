package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class content_recommendactive_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动商品推荐列表")
    public void content_recommendactive_list_true() {

        setUrl("content.recommendactive.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }
}
