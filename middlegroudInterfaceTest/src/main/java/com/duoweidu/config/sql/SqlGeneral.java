package com.duoweidu.config.sql;

import com.duoweidu.model.table.*;
import com.duoweidu.utils.ConfigFileUrl;
import com.duoweidu.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用sql
 */
public class SqlGeneral {

    private static SqlSession session;

    static {
        session = DatabaseUtil.getSqlSession();
    }

    /**
     * 根据当前环境获取env的值
     * 环境类型 1.dev 2.beta 3.线上
     * @return
     */
    private static int getEnv() {
        int env = 1;
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            env = 2;
        }else if ("prod".equals(ConfigFileUrl.getEnv())){
            env = 3;
        }
        return env;
    }

    /**
     * 获取服务器主机表的值
     * @param channel_id
     * @return
     */
    public static ServerHost getServerHostValue(int channel_id) {
        ServerHost serverHost = new ServerHost(channel_id, getEnv());
        return session.selectOne("getEnv", serverHost);
    }

    /**
     * 根据渠道和环境获取服务器主机表的值
     * @param channel_id
     * @param env
     * @return
     */
    public static ServerHost getServerHostValue(int channel_id, int env) {
        ServerHost serverHost = new ServerHost(channel_id, env);
        return session.selectOne("getEnv", serverHost);
    }

    /**
     * 获取接口路径表的值根据名称获取
     * @param channel_id
     * @param name
     * @return
     */
    public static InterfacePath getInterfacePathValue(int channel_id, String name) {
        InterfacePath interfacePath = new InterfacePath(channel_id, name);
        return session.selectOne("getPath", interfacePath);
    }

    /**
     * 获取接口路径表的值根据id获取
     * @param id
     * @param channel_id
     * @return
     */
    public static InterfacePath getInterfacePathValue(int id, int channel_id) {
        InterfacePath interfacePath = new InterfacePath(id, channel_id);
        return session.selectOne("getPathId", interfacePath);
    }

    /**
     * 更新接口路径表报错次数
     * @param id
     * @param channel_id
     * @param errno_count
     */
    public static void updateInterfacePathErrnoCount(int id, int channel_id, int errno_count) {
        InterfacePath interfacePath = new InterfacePath(id, channel_id, errno_count);
        int res = session.update("updatePathErrnoCount", interfacePath);
        session.commit();
        if (res >0) {
            System.out.println("报错次数更新成功");
        }
    }

    /**
     * 获取参数表的值
     * @param channel_id
     * @param name
     * @return
     */
    public static Param getParamValue(int channel_id, String name) {
        /**
         * 环境类型 0.通用 1.dev 2.beta 3.线上
         */
        int env = 0;
        if ("dev".equals(ConfigFileUrl.getEnv())) {
            env = 1;
        }else if ("beta".equals(ConfigFileUrl.getEnv())) {
            env = 2;
        }else if ("prod".equals(ConfigFileUrl.getEnv())) {
            env = 3;
        }
        Param param = new Param(channel_id, env, name);
        return session.selectOne("getParam", param);
    }

    /**
     * 获取参数表的值
     * @param channel_id
     * @param env
     * @param name
     * @return
     */
    public static Param getParamValue(int channel_id,int env, String name) {
        Param param = new Param(channel_id, env, name);
        return session.selectOne("getParam", param);
    }

    /**
     * 记录构建数据
     * @param channel_id
     * @param enabled
     * @param message_status
     * @return
     */
    public static void insertBuildValue(int channel_id, int enabled, int message_status) {
        Build build = new Build(channel_id, getEnv(), enabled, message_status);
        int res = session.insert("insertBuild", build);
        session.commit();
        if (res >0) {
            System.out.println("构建状态写入成功");
        }
//        session.close();
    }

    /**
     * 获取构建数据
     * @param channel_id
     * @return
     */
    public static List<Build> getBuild(int channel_id) {
        Build build = new Build(channel_id, getEnv());
        return session.selectList("getBuild", build);
    }

    /**
     * 获取构建状态
     * @return
     */
    public static ArrayList<Integer> getBuildEnabled(int channel_id) {

        ArrayList<Integer> enabled = new ArrayList<>();
        for (int i = 0; i < SqlGeneral.getBuild(channel_id).size(); i++) {
            enabled.add(SqlGeneral.getBuild(channel_id).get(i).getEnabled());

        }
        return enabled;
    }

    /**
     * 获取发送短信状态
     * @return
     */
    public static ArrayList<Integer> getBuildMessageStatus(int channel_id) {

        ArrayList<Integer> messageStatus = new ArrayList<>();
        for (int i = 0; i < SqlGeneral.getBuild(channel_id).size(); i++) {
            messageStatus.add(SqlGeneral.getBuild(channel_id).get(i).getMessage_status());
        }
        return messageStatus;
    }

    /**
     * 获取最新的构建id,跟环境渠道无关
     * @return
     */
    public static Build getBuildId() {
        return session.selectOne("getBuildId");
    }


    /**
     * 插入报错相关信息
     * @param channel_id
     * @param path_id
     * @param build_id
     * @param params
     * @param status
     * @param result
     */
    public static void insertErrnoResult(int channel_id, int path_id, int build_id, String params, int status, String result) {
        ErrnoResult errnoResult = new ErrnoResult(channel_id, getEnv(), path_id, build_id, params, status, result);
        int res = session.insert("insertErrnoResult", errnoResult);
        session.commit();
        if (res >0) {
            System.out.println("报错相关信息写入成功");
        }
//        session.close();
    }

    public static String getChannelName(int channel_id) {
        return session.selectOne("getChannelName", channel_id);
    }
}
