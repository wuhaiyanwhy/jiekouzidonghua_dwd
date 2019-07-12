package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.GeneralConfig;
<<<<<<< HEAD
import com.duoweidu.config.sql.SqlDetail;
=======
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
>>>>>>> 44ec4803acf31fc798d59b39a56a02df86467d07
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class user_login_test extends HsqInterfaceTest {

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() {
        setUrl("user.login.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile", SqlDetail.getParamValue(0,"mobile")));
        list.add(new BasicNameValuePair("password",SqlDetail.getParamValue(0, "password")));
        list.add(new BasicNameValuePair("type", "1"));
        process(list,true,false);
        //cookie信息存为默认值
        GeneralConfig.store = CallbackInterface.defaultHttpClient.getCookieStore();
        System.out.println(GeneralConfig.store);

    }

}
