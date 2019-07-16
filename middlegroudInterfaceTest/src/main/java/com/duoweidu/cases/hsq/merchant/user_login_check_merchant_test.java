package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.cases.interfaces.HsqMerchantInterfaceTest;
import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.HsqMerchantConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.sql.SqlDetailMultiChannel2;
import com.duoweidu.utils.CallbackInterface;
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

public class user_login_check_merchant_test extends HsqMerchantInterfaceTest {


    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() {
        setUrl("user.login.check.merchant.uri");
        List<NameValuePair> list = new LinkedList<>();
        SqlDetail sqlDetail = new SqlDetailMultiChannel2();
        BasicNameValuePair param1 = new BasicNameValuePair("_username", sqlDetail.getParamValue("username"));
        BasicNameValuePair param2 = new BasicNameValuePair("_password", sqlDetail.getParamValue("password"));
        BasicNameValuePair param3 = new BasicNameValuePair("_csrf_token", sqlDetail.getParamValue("csrf_token"));
        list.add(param1);
        list.add(param2);
        list.add(param3);
        HttpPost post = new HttpPost(url);
        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(list);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);

        CallbackInterface.defaultHttpClient.setCookieStore(HsqMerchantConfig.getStore());
        System.out.println(HsqMerchantConfig.getStore());
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
