package com.duoweidu.utils;

import com.duoweidu.config.SqlGeneral;
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
     * @param name
     * @return
     */
    public static String getUrlByKey(String name) {
        String protocol = SqlTradecenter.getProtocol();
        String server_name = SqlTradecenter.getServerName();
        String path = SqlTradecenter.getPath(name);
        if (path.isEmpty()) {
            throw new IllegalStateException("未知地址");
        }
        return protocol + "://" + server_name + path;
    }

    /**
     * 拼接url，根据渠道
     * @param channel_id
     * @param env
     * @param name
     * @return
     */
    public static String getUrlByKey(int channel_id, int env, String name) {
        String protocol = SqlGeneral.getServerHostValue(channel_id, env).getProtocol();
        String server_name = SqlGeneral.getServerHostValue(channel_id, env).getServer_name();
        String path = SqlGeneral.getInterfacePathValue(channel_id, name).getPath();
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

    //当前渠道
    public static String getChannel() {
        return bundle.getString("channel");
    }

}
