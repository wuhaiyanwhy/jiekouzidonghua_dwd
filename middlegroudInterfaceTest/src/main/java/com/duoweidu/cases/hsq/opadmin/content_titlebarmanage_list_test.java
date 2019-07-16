package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class content_titlebarmanage_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "标题栏管理列表")
    public void content_titlebarmanage_list_true() {

        setUrl("content.titlebarmanage.list.uri");

        JSONObject param = new JSONObject();
        param.put("channel","1");
        param.put("status","");
        param.put("title","");
        param.put("startTime","");
        param.put("endTime","");
        param.put("pageNum","1");
        process(param.toString(),true,true);

    }
}
