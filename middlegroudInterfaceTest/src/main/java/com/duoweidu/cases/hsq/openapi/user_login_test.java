package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class user_login_test extends HsqInterfaceTest {

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() throws IOException {

        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_LOGIN);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile", SqlDetail.getParamValue("mobile",4)));
        list.add(new BasicNameValuePair("password",SqlDetail.getParamValue("password",4)));
        list.add(new BasicNameValuePair("type", "1"));
        process(list,true,false);
        //cookie信息存为默认值
        HsqOpenapiConfig.store = HsqOpenapiConfig.defaultHttpClient.getCookieStore();

    }

}
