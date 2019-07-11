package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.model.InterfaceName;
import com.duoweidu.utils.ConfigFileOpadmin;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
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
import java.util.Locale;
import java.util.ResourceBundle;

public class user_login_check_test {

    //用来存储参数信息
    private String param;
    //用来存储返回的结果
    private String result;

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfigOpadmin.defaultHttpClient = new DefaultHttpClient();
        TestConfigOpadmin.user_login_check_url = ConfigFileOpadmin.getUrl(InterfaceName.USER_LOGIN_CHECK);
        TestConfigOpadmin.user_channel_list = ConfigFileOpadmin.getUrl(InterfaceName.USER_CHANNEL_LIST);
        TestConfigOpadmin.market_actcodesearch = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_ACTCODESEARCH);
        TestConfigOpadmin.market_actcodelist = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_ACTCODELIST);
        TestConfigOpadmin.market_couponactsearch = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_COUPONATCSEARCH);
        TestConfigOpadmin.market_couponsearch = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_COUPONSEARCH);
        TestConfigOpadmin.market_couponlist = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_COUPONLIST);
        TestConfigOpadmin.market_couponoprcdsearch = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_COUPONOPRCDSEARCH);
        TestConfigOpadmin.market_couponoprcdlist = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_COUPONOPRCDLIST);
        TestConfigOpadmin.coupon_alipay_template = ConfigFileOpadmin.getUrl(InterfaceName.COUPON_ALIPAY_TEMPLATE);
        TestConfigOpadmin.coupon_alipay_template_list = ConfigFileOpadmin.getUrl(InterfaceName.COUPON_ALIPAY_TEMPLATE_LIST);
        TestConfigOpadmin.coupon_alipay_activity_index = ConfigFileOpadmin.getUrl(InterfaceName.COUPON_ALIPAY_ACTIVITY_INDEX);
        TestConfigOpadmin.coupon_alipay_activity_list = ConfigFileOpadmin.getUrl(InterfaceName.COUPON_ALIPAY_ACTIVITY_LIST);
        TestConfigOpadmin.coupon_alipay_autopush = ConfigFileOpadmin.getUrl(InterfaceName.COUPON_ALIPAY_AUTOPUSH);
        TestConfigOpadmin.coupon_alipay_autopush_list = ConfigFileOpadmin.getUrl(InterfaceName.COUPON_ALIPAY_AUTOPUSH_LIST);
        TestConfigOpadmin.coupon_alipay_usage = ConfigFileOpadmin.getUrl(InterfaceName.COUPON_ALIPAY_USAGE);
        TestConfigOpadmin.market_firstorderdiscount = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_FIRSTORDERDISCOUNT);
        TestConfigOpadmin.market_firstorderdiscountlist = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_FIRSTORDERDISCOUNTLIST);
        TestConfigOpadmin.anticheat_rule_search = ConfigFileOpadmin.getUrl(InterfaceName.ANTICHEAT_RULE_SEARCH);
        TestConfigOpadmin.anticheat_rule_list = ConfigFileOpadmin.getUrl(InterfaceName.ANTICHEAT_RULE_LIST);
        TestConfigOpadmin.stock_stock_jointaobao = ConfigFileOpadmin.getUrl(InterfaceName.STOCK_STOCK_JOINTAOBAO);
        TestConfigOpadmin.stock_jointaobaolist = ConfigFileOpadmin.getUrl(InterfaceName.STOCK_JOINTAOBAOLIST);
        TestConfigOpadmin.content_hotsearchsug_index = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_HOTSEARCHSUG_INDEX);
        TestConfigOpadmin.content_hotsearchsug_list = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_HOTSEARCHSUG_LIST);
        TestConfigOpadmin.content_topnavigatesearch = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_TOPNAVIGATESEARCH);
        TestConfigOpadmin.content_topnavigatelist = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_TOPNAVIGATELIST);
        TestConfigOpadmin.banner_banneredit = ConfigFileOpadmin.getUrl(InterfaceName.BANNER_BANNEREDIT);
        TestConfigOpadmin.banner_banneronlinelist = ConfigFileOpadmin.getUrl(InterfaceName.BANNER_BANNERONLINELIST);
        TestConfigOpadmin.content_labelbuttonsearch = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_LABELBUTTONSEARCH);
        TestConfigOpadmin.content_labelbuttonlist = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_LABELBUTTONLIST);
        TestConfigOpadmin.content_fixedpromotionboxedit = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_FIXEDPROMOTIONBOXEDIT);
        TestConfigOpadmin.content_fixedpromotionboxlist = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_FIXEDPROMOTIONBOXLIST);
        TestConfigOpadmin.template_listinfo = ConfigFileOpadmin.getUrl(InterfaceName.TEMPLATE_LISTINFO);
        TestConfigOpadmin.content_flowpromotionboxedit = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_FLOWPROMOTIONBOXEDIT);
        TestConfigOpadmin.content_flowpromotionboxlist = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_FLOWPROMOTIONBOXLIST);
        TestConfigOpadmin.content_titlebarmanage_index = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_TITLEBARMANAGE_INDEX);
        TestConfigOpadmin.content_titlebarmanage_list = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_TITLEBARMANAGE_LIST);
        TestConfigOpadmin.content_recommendactive_index = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_RECOMMENDACTIVE_INDEX);
        TestConfigOpadmin.content_recommendactive_list = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_RECOMMENDACTIVE_LIST);
        TestConfigOpadmin.content_advertisemanage_index = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_ADVERTISEMANAGE_INDEX);
        TestConfigOpadmin.content_advertisemanage_list = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_ADVERTISEMANAGE_LIST);
        TestConfigOpadmin.activity_goods_index = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_GOODS_INDEX);
        TestConfigOpadmin.activity_goods_list = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_GOODS_LIST);
        TestConfigOpadmin.content_specialsearch = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_SPECIALSEARCH);
        TestConfigOpadmin.content_speciallist = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_SPECIALLIST);
        TestConfigOpadmin.content_customspecialsearch = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_CUSTOMSPECIALSEARCH);
        TestConfigOpadmin.content_customspeciallist = ConfigFileOpadmin.getUrl(InterfaceName.CONTENT_CUSTOMSPECIALLIST);
        TestConfigOpadmin.wechattemplate_templatelist = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_TEMPLATELIST);
        TestConfigOpadmin.wechattemplate_templateonlinelist = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_TEMPLATEONLINELIST);
        TestConfigOpadmin.wechat_wechatfanssearch = ConfigFileOpadmin.getUrl(InterfaceName.WECHAT_WECHATFANSSEARCH);
        TestConfigOpadmin.wechat_wechatfanslist = ConfigFileOpadmin.getUrl(InterfaceName.WECHAT_WECHATFANSLIST);
        TestConfigOpadmin.market_mtcnotifytpl_show = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_MTCNOTIFYTPL_SHOW);
        TestConfigOpadmin.market_mtcnotify_list = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_MTCNOTIFY_LIST);
        TestConfigOpadmin.market_mtceventnotify_show = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_MTCEVENTNOTIFY_SHOW);
        TestConfigOpadmin.market_mtceventnotify_list = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_MTCEVENTNOTIFY_LIST);
        TestConfigOpadmin.activity_pinonlinesearch = ConfigFileOpadmin.getUrl(InterfaceName.ACTICITY_PINONLINESEARCH);
        TestConfigOpadmin.activity_pinlotteryonline_list = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_PINLOTTERYONLINE_LIST);
        TestConfigOpadmin.activity_pinlottery_edit = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_PINLOTTERY_EDIT);
        TestConfigOpadmin.activity_pinlottery_list = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_PINLOTTERY_LIST);
        TestConfigOpadmin.activity_pinlottery_winnerlist = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_PINLOTTERY_WINNERLIST);
        TestConfigOpadmin.activity_pointsku_edit = ConfigFileOpadmin.getUrl(InterfaceName.ACTICITY_POINTSKU_EDIT);
        TestConfigOpadmin.activity_pointsku_list = ConfigFileOpadmin.getUrl(InterfaceName.ACTICITY_POINTSKU_LIST);
        TestConfigOpadmin.activity_pointsku_config_administration = ConfigFileOpadmin.getUrl(InterfaceName.ACTICITY_POINTSKU_CONFIG_ADMINISTRATION);
        TestConfigOpadmin.activity_pointsku_config_list = ConfigFileOpadmin.getUrl(InterfaceName.ACTICITY_POINTSKU_CONFIG_LIST);
        TestConfigOpadmin.activity_pointwao_index = ConfigFileOpadmin.getUrl(InterfaceName.ACTICITY_POINTWAO_INDEX);
        TestConfigOpadmin.activity_pointwao_list = ConfigFileOpadmin.getUrl(InterfaceName.ACTICITY_POINTWAO_LIST);
        TestConfigOpadmin.assistance_list = ConfigFileOpadmin.getUrl(InterfaceName.ASSISTANCE_LIST);
        TestConfigOpadmin.assistance_activity_info_list = ConfigFileOpadmin.getUrl(InterfaceName.ASSISTANCE_ACTIVITY_INFO_LIST);
        TestConfigOpadmin.assistance_activity_template = ConfigFileOpadmin.getUrl(InterfaceName.ASSISTANCE_TEMPLATE);
        TestConfigOpadmin.assistance_activity_template_list = ConfigFileOpadmin.getUrl(InterfaceName.ASSISTANCE_TEMPLATE_LIST);
        TestConfigOpadmin.content_wechataccountsettings = ConfigFileOpadmin.getUrl(InterfaceName.COTENT_WECHATACCOUNTSETTINGS);
        TestConfigOpadmin.launchbanner_banneredit = ConfigFileOpadmin.getUrl(InterfaceName.LAUNCHBANNER_BANNEREDIT);
        TestConfigOpadmin.launchbanner_banneronlinelist = ConfigFileOpadmin.getUrl(InterfaceName.LAUNCHBANNER_BANNERONLINELIST);
        TestConfigOpadmin.activity_topic_index = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_TOPIC_INDEX);
        TestConfigOpadmin.activity_topic_list = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_TOPIC_LIST);
        TestConfigOpadmin.activity_topic_audit_index = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_TOPIC_AUDIT_INDEX);
        TestConfigOpadmin.activity_topic_audit_list = ConfigFileOpadmin.getUrl(InterfaceName.ACTIVITY_TOPIC_AUDIT_LIST);
        TestConfigOpadmin.wechattemplate_app_index = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_APP_INDEX);
        TestConfigOpadmin.wechattemplate_app_list = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_APP_LIST);
        TestConfigOpadmin.wechattemplate_template_index = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_TEMPLATE_INDEX);
        TestConfigOpadmin.wechattemplate_template_list = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_TEMPLATE_LIST);
        TestConfigOpadmin.wechattemplate_messagepush_index = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_MESSAGEPUSH_INDEX);
        TestConfigOpadmin.wechattemplate_subscribesmessagepush_index = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_SUBSCRIBESMESSAGEPUSH_INDEX);
        TestConfigOpadmin.wechattemplate_subscribesmessagepush_list = ConfigFileOpadmin.getUrl(InterfaceName.WECHATTEMPLATE_SUBSCRIBESMESSAGEPUSH_LIST);
        TestConfigOpadmin.alipaytemplate_app_list = ConfigFileOpadmin.getUrl(InterfaceName.ALIPAYTEMPLATE_APP_LIST);
        TestConfigOpadmin.alipaytemplate_template_index = ConfigFileOpadmin.getUrl(InterfaceName.ALIPAYTEMPLATE_TEMPLATE_INDEX);
        TestConfigOpadmin.alipaytemplate_template_list = ConfigFileOpadmin.getUrl(InterfaceName.ALIPAYTEMPLATE_TEMPLATE_LIST);
        TestConfigOpadmin.alipaytemplate_messagepush_index = ConfigFileOpadmin.getUrl(InterfaceName.ALIPAYTEMPLATE_MESSAGEPUSH_INDEX);
        TestConfigOpadmin.alipaytemplate_messagepush_list = ConfigFileOpadmin.getUrl(InterfaceName.ALIPAYTEMPLATE_MESSAGEPUSH_LIST);
        TestConfigOpadmin.market_mtcevent_index = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_MTCEVENT_INDEX);
        TestConfigOpadmin.market_mtcevent_list = ConfigFileOpadmin.getUrl(InterfaceName.MARKET_MTCEVENT_LIST);
        TestConfigOpadmin.merchant_merchantverify = ConfigFileOpadmin.getUrl(InterfaceName.MERCHANT_MERCHANTVERIFY);
        TestConfigOpadmin.merchant_merchantverifylist = ConfigFileOpadmin.getUrl(InterfaceName.MERCHANT_MERCHANTVERIFYLIST);
        TestConfigOpadmin.merchant_brandverify = ConfigFileOpadmin.getUrl(InterfaceName.MERCHANT_BRANDVERIFY);
        TestConfigOpadmin.merchant_brandverifylist = ConfigFileOpadmin.getUrl(InterfaceName.MERCHANT_BRANDVERIFYLIST);
        TestConfigOpadmin.merchant_couponverify = ConfigFileOpadmin.getUrl(InterfaceName.MERCHANT_COUPONVERIFY);
        TestConfigOpadmin.dealer_dealeraudit = ConfigFileOpadmin.getUrl(InterfaceName.DEALER_DEALERAUDIT);
        TestConfigOpadmin.dealer_dealerlicenselist = ConfigFileOpadmin.getUrl(InterfaceName.DEALER_DEALERLICENSELIST);
        TestConfigOpadmin.sku_skuonlineverify = ConfigFileOpadmin.getUrl(InterfaceName.SKU_SKUONLINEVERIFY);
        TestConfigOpadmin.ugc_ugcsearch = ConfigFileOpadmin.getUrl(InterfaceName.UGC_UGCSEARCH);
        TestConfigOpadmin.ugc_ugclist = ConfigFileOpadmin.getUrl(InterfaceName.UGC_UGCLIST);
        TestConfigOpadmin.trade_ordersearch = ConfigFileOpadmin.getUrl(InterfaceName.TRADE_ORDERSEARCH);
        TestConfigOpadmin.trade_orderlist = ConfigFileOpadmin.getUrl(InterfaceName.TRADE_ORDERLIST);
        TestConfigOpadmin.trade_refundlist = ConfigFileOpadmin.getUrl(InterfaceName.TRADE_REFUNDLIST);
        TestConfigOpadmin.trade_nonuserapplyrefundlist = ConfigFileOpadmin.getUrl(InterfaceName.TRADE_NONUSERAPPLYREFUNDLIST);
        TestConfigOpadmin.trade_paymentabnormalsearch = ConfigFileOpadmin.getUrl(InterfaceName.TRADE_PAYMENTABNORMALSEARCH);
        TestConfigOpadmin.trade_payment_orderpaymentlist = ConfigFileOpadmin.getUrl(InterfaceName.TRADE_PAYMENT_ORDERPAYMENTLIST);
        TestConfigOpadmin.trade_payment_abnormallist = ConfigFileOpadmin.getUrl(InterfaceName.TRADE_PAYMENT_ABNORMALLIST);
        TestConfigOpadmin.express_trance = ConfigFileOpadmin.getUrl(InterfaceName.EXPRESS_TRANCE);
        TestConfigOpadmin.sku_search = ConfigFileOpadmin.getUrl(InterfaceName.SKU_SEARCH);
        TestConfigOpadmin.sku_list = ConfigFileOpadmin.getUrl(InterfaceName.SKU_LIST);
        TestConfigOpadmin.finance_statement = ConfigFileOpadmin.getUrl(InterfaceName.FINANCE_STATEMENT);
        TestConfigOpadmin.finance_statementorder = ConfigFileOpadmin.getUrl(InterfaceName.FINANCE_STATEMENTORDER);
        TestConfigOpadmin.finance_statementorderlist = ConfigFileOpadmin.getUrl(InterfaceName.FINANCE_STATEMENTORDERLIST);
        TestConfigOpadmin.withdraw_account_list_show = ConfigFileOpadmin.getUrl(InterfaceName.WITHDRAW_ACCOUNT_LIST_SHOW);
        TestConfigOpadmin.withdraw_account_list = ConfigFileOpadmin.getUrl(InterfaceName.WITHDRAW_ACCOUNT_LIST);
        TestConfigOpadmin.withdraw_audit_list_show = ConfigFileOpadmin.getUrl(InterfaceName.WITHDRAW_AUDIT_LIST_SHOW);
        TestConfigOpadmin.withdraw_audit_list = ConfigFileOpadmin.getUrl(InterfaceName.WITHDRAW_AUDIT_LIST);
        TestConfigOpadmin.withdraw_income_list_show = ConfigFileOpadmin.getUrl(InterfaceName.WITHDRAW_INCOME_LIST_SHOW);
        TestConfigOpadmin.withdraw_income_list = ConfigFileOpadmin.getUrl(InterfaceName.WITHDRAW_INCOME_LIST);
        TestConfigOpadmin.withdraw_expenditure_list_show = ConfigFileOpadmin.getUrl(InterfaceName.WITHDRAW_EXPENDITURE_LIST_SHOW);
        TestConfigOpadmin.withdraw_expenditure_list = ConfigFileOpadmin.getUrl(InterfaceName.WITHDRAW_EXPENDITURE_LIST);
        TestConfigOpadmin.system_systemnotice = ConfigFileOpadmin.getUrl(InterfaceName.SYSTEM_SYSTEMNOTICE);
        TestConfigOpadmin.system_notice = ConfigFileOpadmin.getUrl(InterfaceName.SYSTEM_NOTICE);
        TestConfigOpadmin.system_notice_list = ConfigFileOpadmin.getUrl(InterfaceName.SYSTEM_NOTICE_LIST);
        TestConfigOpadmin.system_adminuseroplogsearch = ConfigFileOpadmin.getUrl(InterfaceName.SYSTEM_ADMINUSEROPLOGSEARCH);
        TestConfigOpadmin.system_adminuseroploglist = ConfigFileOpadmin.getUrl(InterfaceName.SYSTEM_ADMINUSEROPLOGLIST);
        TestConfigOpadmin.system_adminappset = ConfigFileOpadmin.getUrl(InterfaceName.SYSTEM_ADMINAPPSET);
        TestConfigOpadmin.system_systemconfig_set = ConfigFileOpadmin.getUrl(InterfaceName.SYSTEM_SYSTEMCONFIG_SET);
        TestConfigOpadmin.system_systemconfig_list = ConfigFileOpadmin.getUrl(InterfaceName.SYSTEM_SYSTEMCONFIG_LIST);



    }

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() throws IOException {
         ResourceBundle bundle=ResourceBundle.getBundle("opadmin", Locale.CHINA);
         String  address = bundle.getString("test.url");

        System.out.println(TestConfigOpadmin.user_login_check_url);
        List<NameValuePair> list = new LinkedList<>();
        if(address.equals(Environment.opadminBetaEnv)){
            BasicNameValuePair param1 = new BasicNameValuePair("username", TestSql.getOpadminValue("username"));
            BasicNameValuePair param2 = new BasicNameValuePair("password", TestSql.getOpadminValue("password"));
            BasicNameValuePair param3 = new BasicNameValuePair("captcha", "zqas");
            BasicNameValuePair param4 = new BasicNameValuePair("rememberMe", "1");
            list.add(param1);
            list.add(param2);
            list.add(param3);
            list.add(param4);
        }

        if(address.equals(Environment.opadminOnlineEnv)){
            BasicNameValuePair param1 = new BasicNameValuePair("_username", TestSql.getOpadminValue("username"));
            BasicNameValuePair param2 = new BasicNameValuePair("_password", TestSql.getOpadminValue("password"));
            BasicNameValuePair param3 = new BasicNameValuePair("csrfToken", "-TpTD-Ll2YXfEfjGhv8FjPpVUFQGWhc");
            list.add(param1);
            list.add(param2);
            list.add(param3);
        }

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");

        param = list.toString();
        String results = getJsonResult(entity);



    }

    private String getJsonResult(UrlEncodedFormEntity entity) throws IOException {

        HttpPost post = new HttpPost(TestSql.getOpadminValue("url"));

        post.setEntity(entity);

//        CookieStore cookieStore = new BasicCookieStore();
//        BasicClientCookie cookie1 = new BasicClientCookie("PHPSESSID",OpadminEnvirnomentParam.getPhpSessionId());
//
//        cookieStore.addCookie(cookie1);
//        cookie1.setDomain(OpadminEnvirnomentParam.getDomain());
//        cookie1.setPath("/");
//        cookie1.setVersion(0);

        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.getStore());

//        System.out.println("添加的cookie" + cookieStore);
        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(post);

//        GeneralAssert.codeTest(response,TestConfigOpadmin.user_login_check_url,this.param);

//        int code = response.getStatusLine().getStatusCode();
//        String newuri="";
//        if(code == 302){
//            Header header = response.getFirstHeader("location");
//            newuri = header.getValue();
//            System.out.println(newuri);
//            System.out.println(code);
//
//            HttpGet get = new HttpGet(newuri);
//
//            post.setEntity(entity);
//            response = TestConfigOpadmin.defaultHttpClient.execute(post);
//            code = response.getStatusLine().getStatusCode();
//            System.out.println("login"+code);
//
//
//        }


        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口返回： " + result);

        //cookie信息存为默认值
        TestConfigOpadmin.store = TestConfigOpadmin.defaultHttpClient.getCookieStore();

        System.out.println(TestConfigOpadmin.store);

        return result;
    }

//    @Test(dependsOnGroups = "loginTrue",description = "重定向",groups = "loginTrue1")
//    public void login_true1() throws IOException {
//        HttpGet get = new HttpGet("http://opadmin.beta.haoshiqi.net/market/actcodesearch");
//        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
//        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);
//        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println("接口返回1:  " + result);
//
//    }
//
//    @Test(dependsOnGroups = "loginTrue1",description = "重定向",groups = "loginTrue2")
//    public void login_true2() throws IOException {
//        HttpGet get = new HttpGet("http://opadmin.beta.haoshiqi.net/dailydataindex#dailydata");
//        TestConfigOpadmin.defaultHttpClient.setCookieStore(TestConfigOpadmin.store);
//        HttpResponse response = TestConfigOpadmin.defaultHttpClient.execute(get);
////        GeneralAssert.codeTest(response,TestConfigOpadmin.user_login_check_url,this.param,this.result);
//
//        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println("接口返回1:  " + result);
//        System.out.println(TestConfigOpadmin.store);
//
//    }
}
