package com.duoweidu.config;

import com.duoweidu.model.table.ServerHost;
import com.duoweidu.model.table.InterfacePath;
import com.duoweidu.utils.ConfigFileUrl;
import com.duoweidu.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * 通用sql
 */
public class SqlGeneral {

    private static SqlSession session;

    static {
        try {
            session = DatabaseUtil.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取环境表的值
     * @return
     */
    public static ServerHost getEnvironmentValue(int channel_id) {
        int env = 1;
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            env = 2;
        }else if ("prod".equals(ConfigFileUrl.getEnv())){
            env = 3;
        }
        ServerHost serverHost = new ServerHost(channel_id, env);
        ServerHost value =  session.selectOne("envTradecenter", serverHost);
        return value;
    }

    /**
     * 获取接口路径表的值
     * @return
     */
    public static InterfacePath getInterfacePathValue(int channel_id, String note) {
        InterfacePath interfacePath = new InterfacePath(channel_id, note);
        InterfacePath value =  session.selectOne("tradecenterPath", interfacePath);
        return value;
    }

}
