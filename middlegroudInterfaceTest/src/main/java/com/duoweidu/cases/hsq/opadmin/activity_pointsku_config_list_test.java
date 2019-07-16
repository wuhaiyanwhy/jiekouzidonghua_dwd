package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class activity_pointsku_config_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付宝活动商祥管理列表")
    public void activity_pointsku_config_list_true() {

        setUrl("activity.pointsku.config.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }
}
