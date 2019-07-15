package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class sku_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "宝贝查询列表")
    public void sku_list_true() {

        setUrl("sku.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
