package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_setdefaultaddress_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "orderinitPutong",description = "设置默认收货地址")
    public void user_setdefaultaddress_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_SETDEFAULTADDRESS);
        try {
            JSONObject jsonResult = new JSONObject(HsqOpenapiConfig.orderinitResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            JSONObject address = (JSONObject) data.get("address");
            String id = address.get("id").toString();
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("addressId", id));
            process(list,true,false);
        }catch (JSONException e) {
            GeneralAssert.jsonTest(url,param,result,e);
        }
    }

}
