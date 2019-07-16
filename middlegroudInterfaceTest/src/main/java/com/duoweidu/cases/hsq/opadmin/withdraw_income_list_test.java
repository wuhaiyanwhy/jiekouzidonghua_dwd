package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class withdraw_income_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "对账明细列表")
    public void withdraw_income_list_true() {

        setUrl("withdraw.income.list.uri");
        JSONObject param = new JSONObject();
        param.put("confirmStartTime","2019-01-01");
        param.put("confirmEndTime","2019-01-15");
        param.put("merchantName","");
        param.put("orderNo","");
        process(param.toString(), true, true);

    }

}
