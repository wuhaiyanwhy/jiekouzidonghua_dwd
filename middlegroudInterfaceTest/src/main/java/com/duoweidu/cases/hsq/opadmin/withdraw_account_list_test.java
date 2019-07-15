package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssertChannel;
import com.duoweidu.utils.ConfigFileUrl;
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
        GeneralAssertChannel.listAssert(ConfigFileUrl.getChannel1(), list, url, pathId, param, result);

    }

}
