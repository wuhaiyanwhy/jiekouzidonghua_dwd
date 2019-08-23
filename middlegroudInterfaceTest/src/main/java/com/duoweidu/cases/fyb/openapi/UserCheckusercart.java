package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class UserCheckusercart extends FybInterfaceTest {

    @Test(description = "检查用户购物车")
    public void userCheckusercart() {
        setUrl("user.checkusercart.uri");
        param = "amount=1&skuId=" + SqlDetail.getInstance().getParamValue("skuId");
        process(false,false);
        try {
            JSONObject jsonObject = new JSONObject(result);
            boolean data = jsonObject.getBoolean("data");
            assertTrue("data", data);
        }catch (JSONException e) {
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }
}
