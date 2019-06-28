package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.message.DingDing;
import com.duoweidu.cases.message.Message;
import com.duoweidu.config.SqlTradecenter;

public class Test {

    public static void main(String[] args) {
//        System.out.println(ConfigFileUrl.getUrlByKey("交易中心接口"));
//        System.out.println(SqlTradecenter.getTradeCenterPath("交易中心接口"));
//        System.out.println(SqlTradecenter.getTradeCenterPathId("交易中心接口"));
//        System.out.println(SqlTradecenter.getTradeCenterParamValue(0, "v"));
//        System.out.println(SqlTradecenter.getTradeCenterBuildEnabled().toString());
//        System.out.println(SqlTradecenter.getTradeCenterBuildMessageStatus().toString());
//        SqlTradecenter.updateTradeCenterPathErrnoCount(1);
//        SqlTradecenter.insertTradeCenterErrnoResult(1,"1,2,3", 1,"123");
//        SqlTradecenter.insertTradeCenterBuild(1, 0);
//        Message.sendMessage(SqlTradecenter.getParamValue(0, "mobile1"));
//        DingDing.push(SqlTradecenter.getParamValue(0, "mobile1"),
//                SqlTradecenter.getParamValue(0, "mobile2"),
//                SqlTradecenter.getParamValue(0, "mobile3"));

        Message.sendMessage("【中台】接口已经多次报错了，快去钉钉查看测试报告！！！",
                SqlTradecenter.getParamValue(0, "mobile1"),
                SqlTradecenter.getParamValue(0, "hsqAppId"));

    }
}
