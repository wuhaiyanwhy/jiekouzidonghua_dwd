package com.duoweidu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class DatabaseUtil {

    public static SqlSession getSession(String xml) {
        //获取配置的资源文件
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到SqlSessionFactory，使用类加载器加载xml文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //得到sqlsession对象，这个对象就能执行配置文件中的sql语句啦
        SqlSession session = factory.openSession();

        return session;
    }

    //interface_test库
    public static SqlSession getSqlSession() {
        SqlSession session = getSession("databaseConfig.xml");
        //防止插入表情乱码
        try {
            session.getConnection().prepareStatement("SET NAMES 'utf8mb4'").execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return session;
    }


    //iqg_db_beta库
    public static SqlSession getIqgBetaSqlSession() {
        return getSession("iqgBetaDatabaseConfig.xml");
    }

    //msf_beta库
    public static SqlSession getMsfBetaSqlSession() {
        return getSession("msfBetaDatabaseConfig.xml");
    }

}
