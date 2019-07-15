package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.HsqOpadminConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.sql.SqlDetailMultiChannel1;
import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

public class user_login_check_test extends HsqOpadminInterfaceTest {

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() {
        setUrl("user.login_check.uri");
        SqlDetail sqlDetail = new SqlDetailMultiChannel1();
        List<NameValuePair> list = new LinkedList<>();
        if("beta".equals(ConfigFileUrl.getEnv())){
            BasicNameValuePair param1 = new BasicNameValuePair("username", sqlDetail.getParamValue("username"));
            BasicNameValuePair param2 = new BasicNameValuePair("password", sqlDetail.getParamValue("password"));
            BasicNameValuePair param3 = new BasicNameValuePair("captcha", "zqas");
            BasicNameValuePair param4 = new BasicNameValuePair("rememberMe", "1");
            list.add(param1);
            list.add(param2);
            list.add(param3);
            list.add(param4);
        }

        if("prod".equals(ConfigFileUrl.getEnv())){
            BasicNameValuePair param1 = new BasicNameValuePair("_username", sqlDetail.getParamValue("username"));
            BasicNameValuePair param2 = new BasicNameValuePair("_password", sqlDetail.getParamValue("password"));
            BasicNameValuePair param3 = new BasicNameValuePair("csrfToken", "-TpTD-Ll2YXfEfjGhv8FjPpVUFQGWhc");
            list.add(param1);
            list.add(param2);
            list.add(param3);
        }
        HttpPost post = new HttpPost(url);
        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(list);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);

        CallbackInterface.defaultHttpClient.setCookieStore(HsqOpadminConfig.getStore());
        System.out.println(HsqOpadminConfig.getStore());
        HttpResponse response = null;
        try {
            response = CallbackInterface.defaultHttpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("接口返回： " + result);
        //cookie信息存为默认值
        GeneralConfig.store = CallbackInterface.defaultHttpClient.getCookieStore();

    }

}
