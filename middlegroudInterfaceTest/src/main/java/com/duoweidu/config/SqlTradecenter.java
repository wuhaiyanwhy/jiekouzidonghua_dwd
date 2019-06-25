package com.duoweidu.config;

/**
 * 交易中心sql
 */
public class SqlTradecenter {

    /**
     * 获取环境表的协议(交易中心)
     * @return
     */
    public static String getTradeCenterProtocol() {
        return SqlGeneral.getEnvironmentValue(6).getProtocol();
    }

    /**
     * 获取环境表的服务器名称(交易中心)
     * @return
     */
    public static String getTradeCenterServerName() {
        return SqlGeneral.getEnvironmentValue(6).getServer_name();
    }

    /**
     * 获取接口路径表的路径
     * @return
     */
    public static String getTradeCenterPath(String note) {
        return SqlGeneral.getInterfacePathValue(6, note).getPath();
    }

}
