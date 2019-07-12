package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class activity_goods_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商品列表排序列表")
    public void activity_goods_list_true() {

        setUrl("activity.goods.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, true, true);
        String results = getJsonResult(list);
        process(list, 2, true, false);
        process();
        process(true);
        process(true, true);
        process(list);
        process(list, true);
        process(list, false, false);
        process(list, 2, );


    }

}
