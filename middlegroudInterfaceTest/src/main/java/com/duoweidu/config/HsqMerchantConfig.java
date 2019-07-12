package com.duoweidu.config;

import com.duoweidu.config.sql.SqlDetailMultiChannel2;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

public class HsqMerchantConfig {

    //用来储存cookies信息
    public static CookieStore getStore(){
        CookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie cookie1 = new BasicClientCookie("PHPSESSID", SqlDetailMultiChannel2.getParamValue("PHPSESSID"));
        cookieStore.addCookie(cookie1);
        cookie1.setDomain(SqlDetailMultiChannel2.getParamValue("domain"));
        cookie1.setPath("/");
        cookie1.setVersion(0);
        return cookieStore;
    }
}
