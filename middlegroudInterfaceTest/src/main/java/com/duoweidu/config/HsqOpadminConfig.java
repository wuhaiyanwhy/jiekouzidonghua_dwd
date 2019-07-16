package com.duoweidu.config;

import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.sql.SqlDetailMultiChannel1;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

public class HsqOpadminConfig {

    //用来储存cookies信息
    public static CookieStore getStore(){
        CookieStore cookieStore = new BasicCookieStore();
        SqlDetail sqlDetail = new SqlDetailMultiChannel1();
        BasicClientCookie cookie1 = new BasicClientCookie("PHPSESSID", sqlDetail.getParamValue("PHPSESSID"));
        cookieStore.addCookie(cookie1);
        cookie1.setDomain(sqlDetail.getParamValue("domain"));
        cookie1.setPath("/");
        cookie1.setVersion(0);
        return cookieStore;
    }
}
