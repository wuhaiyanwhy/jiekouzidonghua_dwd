package com.duoweidu.config;

import java.util.ArrayList;

/**
 * 交易中心sql
 */
public class SqlTradecenter {

    /**
     * 交易中心渠道号默认为6
     * 1.好食期 2.爱抢购 3.觅食蜂 4.返一半 5.巨食阵 6.交易中心
     */
    private static final int chanel_id = 6;

    /**
     * 获取服务主机表的协议
     *
     * @return
     */
    public static String getTradeCenterProtocol() {
        return SqlGeneral.getServerHostValue(chanel_id).getProtocol();
    }

    /**
     * 获取服务主机表的服务器名称
     *
     * @return
     */
    public static String getTradeCenterServerName() {
        return SqlGeneral.getServerHostValue(chanel_id).getServer_name();
    }

    /**
     * 获取接口路径表的路径
     * @param name
     * @return
     */
    public static String getTradeCenterPath(String name) {
        return SqlGeneral.getInterfacePathValue(chanel_id, name).getPath();
    }

    /**
     * 获取接口路径表的id
     * @param name
     * @return
     */
    public static int getTradeCenterPathId(String name) {
        return SqlGeneral.getInterfacePathValue(chanel_id, name).getId();
    }

    /**
     * 获取接口表的报错次数
     * @param id
     * @return
     */
    public static int getTradeCenterPathErrnoCount(int id) {
        return SqlGeneral.getInterfacePathValue(id, chanel_id).getErrno_count();
    }

    /**
     * 更新报错次数，根据path_id 自增1
     * @param id
     */
    public static void updateTradeCenterPathErrnoCount(int id) {
        SqlGeneral.updateInterfacePathErrnoCount(id, chanel_id, getTradeCenterPathErrnoCount(id) + 1);
    }

    /**
     * 获取参数表的参数值
     * @param name
     * @return
     */
    public static String getTradeCenterParamValue(String name) {
        return SqlGeneral.getParamValue(chanel_id, name).getValue();
    }

    /**
     * 获取参数表的参数值
     *
     * @param env
     * @param name
     * @return
     */
    public static String getTradeCenterParamValue(int env, String name) {
        return SqlGeneral.getParamValue(chanel_id, env, name).getValue();
    }

    /**
     * 插入构建状态
     * @param enabled
     * @param message_status
     */
    public static void insertTradeCenterBuild(int enabled, int message_status) {
        SqlGeneral.insertBuildValue(chanel_id, enabled, message_status);
    }

    /**
     * 获取构建状态
     * @return
     */
    public static ArrayList<Integer> getTradeCenterBuildEnabled() {

        ArrayList<Integer> enabled = new ArrayList<>();
        for (int i = 0; i < SqlGeneral.getBuild(chanel_id).size(); i++) {
            enabled.add(SqlGeneral.getBuild(chanel_id).get(i).getEnabled());

        }
        return enabled;
    }

    /**
     * 获取发送短信状态
     * @return
     */
    public static ArrayList<Integer> getTradeCenterBuildMessageStatus() {

        ArrayList<Integer> messageStatus = new ArrayList<>();
        for (int i = 0; i < SqlGeneral.getBuild(chanel_id).size(); i++) {
            messageStatus.add(SqlGeneral.getBuild(chanel_id).get(i).getMessage_status());
        }
        return messageStatus;
    }

    /**
     * 获取最新的构建id
     * @return
     */
    public static ArrayList<Integer> getTradeCenterBuildId() {
        ArrayList<Integer> id = new ArrayList<>();
        for (int i = 0; i < SqlGeneral.getBuild(chanel_id).size(); i++) {
            id.add(SqlGeneral.getBuild(chanel_id).get(i).getId());
        }
        return id;
    }

    /**
     * 插入报错相关信息
     * @param path_id
     * @param params
     * @param status
     * @param result
     */
    public static void insertTradeCenterErrnoResult(int path_id, String params, int status, String result) {
        SqlGeneral.insertErrnoResult(chanel_id, path_id, getTradeCenterBuildId().get(0), params, status, result);
    }


}