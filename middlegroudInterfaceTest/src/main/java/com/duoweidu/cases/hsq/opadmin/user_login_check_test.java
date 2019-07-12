package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.sql.SqlDetailMultiChannel1;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_login_check_test extends HsqOpadminInterfaceTest {

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() {
        setUrl("user.login_check.uri");
        List<NameValuePair> list = new LinkedList<>();
        if("beta".equals(ConfigFileUrl.getEnv())){
            BasicNameValuePair param1 = new BasicNameValuePair("username", SqlDetailMultiChannel1.getParamValue("username"));
            BasicNameValuePair param2 = new BasicNameValuePair("password", SqlDetailMultiChannel1.getParamValue("password"));
            BasicNameValuePair param3 = new BasicNameValuePair("captcha", "zqas");
            BasicNameValuePair param4 = new BasicNameValuePair("rememberMe", "1");
            list.add(param1);
            list.add(param2);
            list.add(param3);
            list.add(param4);
        }

        if("prod".equals(ConfigFileUrl.getEnv())){
            BasicNameValuePair param1 = new BasicNameValuePair("_username", SqlDetailMultiChannel1.getParamValue("username"));
            BasicNameValuePair param2 = new BasicNameValuePair("_password", SqlDetailMultiChannel1.getParamValue("password"));
            BasicNameValuePair param3 = new BasicNameValuePair("csrfToken", "-TpTD-Ll2YXfEfjGhv8FjPpVUFQGWhc");
            list.add(param1);
            list.add(param2);
            list.add(param3);
        }
        process(list, false, false);
        //cookie信息存为默认值
        GeneralConfig.store = GeneralConfig.defaultHttpClient.getCookieStore();

    }

}
