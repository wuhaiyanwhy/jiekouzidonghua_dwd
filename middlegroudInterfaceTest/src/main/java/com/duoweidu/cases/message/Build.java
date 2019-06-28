package com.duoweidu.cases.message;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.SqlGeneral;
import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.AfterSuite;

/**
 * 记录构建状态，若构建失败发送钉钉和短信
 */

public class Build {


    @AfterSuite(description = "记录构建状态")
    public static void build() {
        int enabled = 1;
        int message_status = 0;

        //当构建失败时 enabled为0
        if (GeneralConfig.errnoList != null && GeneralConfig.errnoList.size() >0) {
            enabled = 0;
            //如果是线上并且不是调试状态则发送短信和钉钉提醒
            if ("prod".equals(ConfigFileUrl.getEnv()) && "false".equals(ConfigFileUrl.getDebug())) {
                DingDing.push("中台接口又挂了，快去看测试报告",
                        SqlTradecenter.getParamValue(0, "mobile1"),
                        SqlTradecenter.getParamValue(0, "mobile2"),
                        SqlTradecenter.getParamValue(0, "mobile3"));
                System.out.println("钉钉消息发送成功");
            }
        }

        //当连续2次构建失败并且最近10次未发送短信的时候发送短信
        //如果表里有数据再走此逻辑
        if (SqlGeneral.getBuildEnabled(6).size() >0 && SqlGeneral.getBuildMessageStatus(6).size() > 0) {
            if (SqlGeneral.getBuildEnabled(6).get(0) == 0 && enabled == 0 &&
                    SqlGeneral.getBuildMessageStatus(6).toString().equals("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]")) {
                message_status = 1;
                Message.sendMessage("【中台】接口已经多次报错了，快去钉钉查看测试报告！！！",
                        SqlTradecenter.getParamValue(0, "mobile1"),
                        SqlTradecenter.getParamValue(0, "hsqAppId"));
                Message.sendMessage("【中台】接口已经多次报错了，快去钉钉查看测试报告！！！",
                        SqlTradecenter.getParamValue(0, "mobile2"),
                        SqlTradecenter.getParamValue(0, "hsqAppId"));
                Message.sendMessage("【中台】接口已经多次报错了，快去钉钉查看测试报告！！！",
                        SqlTradecenter.getParamValue(0, "mobile3"),
                        SqlTradecenter.getParamValue(0, "hsqAppId"));
                System.out.println("短信发送成功");
            }
        }

        //插入构建状态
        SqlTradecenter.insertBuild(enabled, message_status);


    }


}
