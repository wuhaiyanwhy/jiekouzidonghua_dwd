package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.MsfConfig;
<<<<<<< HEAD
import com.duoweidu.config.sql.SqlDetail;
=======
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
>>>>>>> 44ec4803acf31fc798d59b39a56a02df86467d07
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserLogin extends MsfInterfaceTest {


    @Test(groups = "loginTrue",description = "用户成功登录接口")
    public void userLogin() {

        setUrl("user.login.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("login_type","5"));
        list.add(new BasicNameValuePair("remember","1"));
        list.add(new BasicNameValuePair("mobile", SqlDetail.getParamValue(0, "mobile")));
        list.add(new BasicNameValuePair("password",SqlDetail.getParamValue(0, "password")));

        process(list,true,false);
        //cookie信息储存未默认值
        GeneralConfig.store = CallbackInterface.defaultHttpClient.getCookieStore();
        System.out.println("cookie信息：" + GeneralConfig.store);
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            MsfConfig.token = data.get("token").toString();
            MsfConfig.userId = data.get("id").toString();
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }
}
