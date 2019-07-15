package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class withdraw_expenditure_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商户支出明细列表")
    public void withdraw_expenditure_list_true() {

        setUrl("withdraw.expenditure.list.uri");
        JSONObject param = new JSONObject();
        param.put("createStartTime","2019-01-01");
        param.put("createEndTime","2019-01-15");
        param.put("updateStartTime","null");
        param.put("updateEndTime","null");
        param.put("endStatus","0");
        param.put("type","0");

        process(param.toString());
        JSONObject jsonObject = new JSONObject(result);
        JSONArray list = (JSONArray) jsonObject.get("list");
        generalAssert.listAssert(list, url, pathId, param.toString(), result);

    }

}
