package com.duoweidu.cases.message;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.sql.SqlDetail;
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
                JenkinsBuild.jenkinsLastBuild();
                DingDing.push("接口又挂了，快去看测试报告" + "\n传送门：" + GeneralConfig.url,
                        SqlDetail.getInstance().getParamValue(0, "mobile1"),
                        SqlDetail.getInstance().getParamValue(0, "mobile2"),
                        SqlDetail.getInstance().getParamValue(0, "mobile3"));
                System.out.println("钉钉消息发送成功");

                //当连续2次构建失败并且最近10次未发送短信的时候发送短信
                //如果表里有数据再走此逻辑
                if (SqlDetail.getInstance().getBuildEnabled().size() >0 && SqlDetail.getInstance().getBuildMessageStatus().size() > 0) {
                    if (SqlDetail.getInstance().getBuildEnabled().get(0) == 0 &&
                            SqlDetail.getInstance().getBuildMessageStatus().toString().equals("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]")) {
                        message_status = 1;
                        Message.sendMessage("接口已经多次报错了，快去钉钉查看测试报告！！！",
                                SqlDetail.getInstance().getParamValue(0, "mobile1"),
                                SqlDetail.getInstance().getParamValue(0, "appId"));
                        Message.sendMessage("接口已经多次报错了，快去钉钉查看测试报告！！！",
                                SqlDetail.getInstance().getParamValue(0, "mobile2"),
                                SqlDetail.getInstance().getParamValue(0, "appId"));
                        Message.sendMessage("接口已经多次报错了，快去钉钉查看测试报告！！！",
                                SqlDetail.getInstance().getParamValue(0, "mobile3"),
                                SqlDetail.getInstance().getParamValue(0, "appId"));
                        System.out.println("短信发送成功");
                    }
                }
            }

        }
        //插入构建状态
        SqlDetail.getInstance().insertBuild(enabled, message_status);


    }


}
