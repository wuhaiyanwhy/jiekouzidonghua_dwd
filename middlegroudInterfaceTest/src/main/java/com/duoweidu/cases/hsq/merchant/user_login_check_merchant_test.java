package com.duoweidu.cases.hsq.merchant;

import com.duoweidu.model.InterfaceName;
import com.duoweidu.utils.ConfigFileMerchant;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_login_check_merchant_test {

    //用来存储参数信息
    private String param;
    //用来储存返回的结果
    private String result;

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfigMerchant.defaultHttpClient = new DefaultHttpClient();
        TestConfigMerchant.user_login_check_merchant = ConfigFileMerchant.getUrl(InterfaceName.USER_LOGIN_CHECK_MERCHANT);
        TestConfigMerchant.merchant_onlinechat_token = ConfigFileMerchant.getUrl(InterfaceName.MERCHANT_ONLINECHAT_TOKEN);
        TestConfigMerchant.merchant_info = ConfigFileMerchant.getUrl(InterfaceName.MERCHANT_INFO);
        TestConfigMerchant.merchant_address = ConfigFileMerchant.getUrl(InterfaceName.MERCHANT_ADDRESS);
        TestConfigMerchant.merchant_promotions = ConfigFileMerchant.getUrl(InterfaceName.MERCHANT_PROMOTIONS);
        TestConfigMerchant.merchant_couponedit = ConfigFileMerchant.getUrl(InterfaceName.MERCHANT_COUPONEDIT);
        TestConfigMerchant.merchant_couponlist = ConfigFileMerchant.getUrl(InterfaceName.MERCHANT_COUPONLIST);
        TestConfigMerchant.merchant_notice = ConfigFileMerchant.getUrl(InterfaceName.MERCHANT_NOTICE);
        TestConfigMerchant.trade_productsoldlist = ConfigFileMerchant.getUrl(InterfaceName.TRADE_PRODUCTSOLDLIST);
        TestConfigMerchant.trade_ugc_ugclist = ConfigFileMerchant.getUrl(InterfaceName.TRADE_UGC_UGCLIST);
        TestConfigMerchant.trade_merchant_ugclist = ConfigFileMerchant.getUrl(InterfaceName.TRADE_MERCHANT_UGCLIST);
        TestConfigMerchant.trade_statement = ConfigFileMerchant.getUrl(InterfaceName.TRADE_STATEMENT);
        TestConfigMerchant.trade_statementlist = ConfigFileMerchant.getUrl(InterfaceName.TRADE_STATEMENTLIST);
        TestConfigMerchant.express_productsendlist = ConfigFileMerchant.getUrl(InterfaceName.EXPRESS_PRODUCTSENDLIST);
        TestConfigMerchant.express_expressfeetemplate = ConfigFileMerchant.getUrl(InterfaceName.EXPRESS_EXPRESSFEETEMPLATE);
        TestConfigMerchant.express_trance_merchant = ConfigFileMerchant.getUrl(InterfaceName.EXPRESS_TRANCE_MERCHANT);
        TestConfigMerchant.product_selectcategory = ConfigFileMerchant.getUrl(InterfaceName.PRODUCT_SELECTCATEGORY);
        TestConfigMerchant.merchant_productskulist = ConfigFileMerchant.getUrl(InterfaceName.MERCHANT_PRODUCTSKULIST);
        TestConfigMerchant.cs_refundlist = ConfigFileMerchant.getUrl(InterfaceName.CS_REFUNDLIST);
        TestConfigMerchant.activity_topic = ConfigFileMerchant.getUrl(InterfaceName.ACTIVITY_TOPIC);
        TestConfigMerchant.activity_gettopiclist = ConfigFileMerchant.getUrl(InterfaceName.ACTIVITY_GETTOPICLIST);
        TestConfigMerchant.activity_registration = ConfigFileMerchant.getUrl(InterfaceName.ACTIVITY_REGISTRATION);
        TestConfigMerchant.activity_getregistrationlist = ConfigFileMerchant.getUrl(InterfaceName.ACTIVITY_GETREGISTRATIONLIST);
        TestConfigMerchant.withdraw_income = ConfigFileMerchant.getUrl(InterfaceName.WITHDRAW_INCOME);
        TestConfigMerchant.withdraw_income_list_merchant = ConfigFileMerchant.getUrl(InterfaceName.WITHDRAW_INCOME_LIST_MERCHANT);
        TestConfigMerchant.withdraw_expenditure = ConfigFileMerchant.getUrl(InterfaceName.WITHDRAW_EXPENDITURE);
        TestConfigMerchant.withdraw_expenditure_list_merchant = ConfigFileMerchant.getUrl(InterfaceName.WITHDRAW_EXPENDITURE_LIST_MERCHANT);

    }

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() throws IOException {
        System.out.println(TestConfigMerchant.user_login_check_merchant);
        List<BasicNameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("_username", TestSql.getMerchantValue("username"));
        BasicNameValuePair param2 = new BasicNameValuePair("_password", TestSql.getMerchantValue("password"));
        BasicNameValuePair param3 = new BasicNameValuePair("_csrf_token", TestSql.getMerchantValue("csrf_token"));
        list.add(param1);
        list.add(param2);
        list.add(param3);

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);

        param = list.toString();
        String results = getJsonResult(entity);
    }

    private String getJsonResult(UrlEncodedFormEntity entity) throws IOException {

        HttpPost post = new HttpPost(TestConfigMerchant.user_login_check_merchant);
        post.setEntity(entity);

        TestConfigMerchant.defaultHttpClient.setCookieStore(TestConfigMerchant.getStore());
        System.out.println(TestConfigMerchant.getStore());
        HttpResponse response = TestConfigMerchant.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        //cookie信息存为默认值
        TestConfigMerchant.store = TestConfigMerchant.defaultHttpClient.getCookieStore();
        System.out.println( TestConfigOpadmin.store);

        System.out.println(TestConfigOpadmin.store);

        return result;

    }

}
