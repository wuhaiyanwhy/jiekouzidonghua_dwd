package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import com.duoweidu.config.sql.SqlDetailMultiChannel2;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_login_check_merchant_test extends HsqMerchantInterfaceTest {


    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() {
        setUrl("user.login.check.merchant.uri");
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("_username", SqlDetailMultiChannel2.getParamValue("username"));
        BasicNameValuePair param2 = new BasicNameValuePair("_password", SqlDetailMultiChannel2.getParamValue("password"));
        BasicNameValuePair param3 = new BasicNameValuePair("_csrf_token", SqlDetailMultiChannel2.getParamValue("csrf_token"));
        list.add(param1);
        list.add(param2);
        list.add(param3);
        process(list);
    }

}
