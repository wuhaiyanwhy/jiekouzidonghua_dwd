package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserSetdefaultaddress extends FybInterfaceTest {

    private ResData model;

    @Test(dependsOnGroups = "orderOrderinit",description = "设置默认收货地址")
    public void userSetdefaultaddress() {
        setUrl("user.setdefaultaddress.uri");
        try {
            JSONObject jsonResult = new JSONObject(FybConfig.orderinitResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            JSONObject address = (JSONObject) data.get("address");
            String id = address.get("id").toString();
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("addressId", id));
            process(list,true,false);
            model = sparseJson(ResData.class);
            detailAssert();
        }catch (JSONException e) {
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    private void detailAssert() {
        assertTrue("res", model.res);
    }

}
