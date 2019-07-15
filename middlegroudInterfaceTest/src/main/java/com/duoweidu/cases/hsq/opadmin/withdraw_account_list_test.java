package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssertMultiChannel1;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class withdraw_account_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商家提现列表")
    public void withdraw_account_list_true() {

        setUrl("withdraw.account.list.uri");
        process();
        JSONObject jsonObject = new JSONObject(result);
        JSONArray list = (JSONArray) jsonObject.get("list");
        GeneralAssertMultiChannel1.listAssert(list, url, pathId, param, result);

    }

}
