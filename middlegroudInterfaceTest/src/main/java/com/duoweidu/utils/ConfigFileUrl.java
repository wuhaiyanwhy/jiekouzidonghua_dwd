package com.duoweidu.utils;

import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.sql.SqlGeneral;

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
        String protocol = SqlDetail.getProtocol();
        String server_name = SqlDetail.getServerName();
        String path = SqlDetail.getPath(name);
        if (path.isEmpty()) {
            throw new IllegalStateException("未知地址");
        }
        return protocol + "://" + server_name + path;
    }

    /**
     * 拼接url
     * @param name
     * @return
     */
    public static String getUrlByKey(String name, int channel_id) {
        String protocol = SqlGeneral.getServerHostValue(channel_id).getProtocol();
        String server_name = SqlGeneral.getServerHostValue(channel_id).getServer_name();
        String path = SqlGeneral.getInterfacePathValue(channel_id, name).getPath();
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
    public static int getChannel() {
        return Integer.parseInt(bundle.getString("channel"));
    }


    /**
     * 有多个渠道时设置以下方法
     * @return
     */
    public static int getChannel1() {
        return Integer.parseInt(bundle.getString("channel1"));
    }


    public static int getChannel2() {
        return Integer.parseInt(bundle.getString("channel2"));
    }
}
