package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class content_advertisemanage_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "广告位管理列表")
    public void content_advertisemanage_list_true() {

        setUrl("content.advertisemanage.list.uri");
        JSONObject param = new JSONObject();
        param.put("channel","1");
        param.put("status","");
        param.put("title","");
        param.put("startTime","");
        param.put("endTime","");
        param.put("pageNum","1");
        process(param.toString(), true, true);

    }

}
