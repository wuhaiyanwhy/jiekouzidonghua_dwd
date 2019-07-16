package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_deleteaddress_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "addaddress",description = "删除用户地址")
    public void user_deleteaddress_true() {
        setUrl("user.deleteaddress.uri");
        try {
            JSONObject jsonResult = new JSONObject(HsqOpenapiConfig.addaddressResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            String id = data.get("id").toString();
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("addressId", id));
            process(list,true,false);
        }catch (JSONException e) {
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

}
