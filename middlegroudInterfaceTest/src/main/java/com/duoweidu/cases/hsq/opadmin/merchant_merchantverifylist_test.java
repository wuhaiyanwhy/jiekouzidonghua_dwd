package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class merchant_merchantverifylist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "基本信息审核列表")
    public void merchant_merchantverifylist_true() {

        setUrl("merchant.merchantverifylist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
