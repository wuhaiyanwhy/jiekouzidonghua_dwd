package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.TestConfigOpenapi;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserLogin extends OpenapiInterfaceTest {


    @Test(groups = "loginTrue",description = "用户成功登录接口")
    public void userLogin() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_LOGIN);

        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("login_type","5"));
        list.add(new BasicNameValuePair("remember","1"));
        list.add(new BasicNameValuePair("mobile", TestSql.getValue("mobile",4)));
        list.add(new BasicNameValuePair("password",TestSql.getValue("password",4)));

        process(list,true,false);
        //cookie信息储存未默认值
        TestConfigOpenapi.store = TestConfigOpenapi.defaultHttpClient.getCookieStore();
        System.out.println("cookie信息：" + TestConfigOpenapi.store);
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            TestConfigOpenapi.token = data.get("token").toString();
            TestConfigOpenapi.userId = data.get("id").toString();
        }catch (JSONException e){
            GeneralAssert.jsonTest(url,param,result,e);
        }
    }
}
