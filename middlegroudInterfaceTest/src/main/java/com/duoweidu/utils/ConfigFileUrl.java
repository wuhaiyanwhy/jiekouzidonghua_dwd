package com.duoweidu.utils;

import com.duoweidu.config.SqlTradecenter;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 获取环境，开关，URL地址相关
 */

public class ConfigFileUrl {

    private static ResourceBundle bundle=ResourceBundle.getBundle("switch", Locale.CHINA);

    /**
     * 拼接url
     * @param note
     * @return
     */
    public static String getUrlByKey(String note) {
        String protocol = SqlTradecenter.getTradeCenterProtocol();
        String server_name = SqlTradecenter.getTradeCenterServerName();
        String path = SqlTradecenter.getTradeCenterPath(note);
        if (path.isEmpty()) {
            throw new IllegalStateException("未知地址");
        }
        return protocol + "://" + server_name + path;
    }

    //环境
    public static String getEnv() {
        return bundle.getString("test.env");
    }

    //调试开关
    public static String getDebug() {
        return bundle.getString("debug");
    }

}
