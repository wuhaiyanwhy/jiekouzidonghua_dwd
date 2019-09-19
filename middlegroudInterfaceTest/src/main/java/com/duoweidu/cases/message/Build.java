package com.duoweidu.cases.message;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.sql.SqlGeneral;
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

        int errnoCount = GeneralConfig.errnoList.size() - GeneralConfig.limitTimeList.size();
        String errno_message = "超时的接口个数：" + GeneralConfig.limitTimeList.size() +
                "\n报错的接口个数：" + errnoCount +
                "\n错误接口总个数：" + GeneralConfig.errnoList.size();

        //当构建失败时 enabled为0
        if (GeneralConfig.errnoList != null && GeneralConfig.errnoList.size() > 0) {
            enabled = 0;
            //如果是不是调试状态则发送钉钉提醒
            if ("false".equals(ConfigFileUrl.getDebug())) {

                JenkinsBuild.jenkinsLastBuild();
                String name = "【" + SqlDetail.getInstance().getChannelName() + "】";
                String url = GeneralConfig.url + "artifact/middlegroudInterfaceTest/test-output/InterfaceReport.html";
                String message = "接口又挂了，快去看测试报告！！！\n" + errno_message ;

                //如果接口超时&超时的数组长度不等于总的数组长度时报错文案改变
                if (GeneralConfig.limitTimeList.size() > 0 && GeneralConfig.errnoList.size() == GeneralConfig.limitTimeList.size()) {
                    message = "接口又超时了，快去看测试报告！！！\n" + errno_message;
                }

                //如果多个接口报错时报错文案改变
                if (errnoCount >= 5) {
                    message = "项目已崩（多个接口报错），快去看测试报告！！！\n" + errno_message;
                }

                //beta环境文案改变
                if ("beta".equals(ConfigFileUrl.getEnv())) {
                    message = "beta环境接口报错啦，快去看看是不是你提交的bug！！！\n" + errno_message;
                }

                String dingdingContent = name + message + "\n传送门：" + url;
                DingDing.push(dingdingContent,
                        SqlDetail.getInstance().getParamValue(0, "mobile1"),
                        SqlDetail.getInstance().getParamValue(0, "mobile2"),
                        SqlDetail.getInstance().getParamValue(0, "mobile3"));
                System.out.println("钉钉消息发送成功");

                //1.当连续2次构建失败并且最近10次未发送短信的时候发送短信
                //2.当当前构建有多个接口（例如：>=5）报错时发送短信
                //如果是线上环境&表里有数据再走此逻辑
                String content = "接口已经多次报错了，快去钉钉查看测试报告！！！\n" + errno_message;
                if ("prod".equals(ConfigFileUrl.getEnv()) && SqlDetail.getInstance().getBuildEnabled().size() >0 && SqlDetail.getInstance().getBuildMessageStatus().size() > 0) {
                    if (errnoCount >= 5 ) {
                        message_status = 1;
                        content = "项目已崩（多个接口报错），快去钉钉查看测试报告！！！\n" + errno_message;
                        sendMessage(content);
                    }else if (SqlDetail.getInstance().getBuildEnabled().get(0) == 0 &&
                            SqlDetail.getInstance().getBuildMessageStatus().toString().equals("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]")) {
                        message_status = 1;
                        sendMessage(content);
                    }
                }
            }

        }
        //插入构建状态
        SqlDetail.getInstance().insertBuild(enabled, message_status);
        //回写构建id
        if (GeneralConfig.errnoList.size() > 0) {
            for (int i = 0; i < GeneralConfig.errnoList.size(); i++) {
                SqlGeneral.updateErrnoResult(GeneralConfig.errnoList.get(i), SqlGeneral.getBuildId().getId());
            }
        }


    }


    private static void sendMessage(String content) {
        Message.sendMessage(content,
                SqlDetail.getInstance().getParamValue(0, "mobile1"),
                SqlDetail.getInstance().getParamValue(0, "appId"));
        Message.sendMessage(content,
                SqlDetail.getInstance().getParamValue(0, "mobile2"),
                SqlDetail.getInstance().getParamValue(0, "appId"));
        Message.sendMessage(content,
                SqlDetail.getInstance().getParamValue(0, "mobile3"),
                SqlDetail.getInstance().getParamValue(0, "appId"));
        System.out.println("短信发送成功");
    }


}
