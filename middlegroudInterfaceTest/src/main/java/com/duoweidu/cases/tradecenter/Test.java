package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.message.Message;
import com.duoweidu.config.SqlDetail;

public class Test {

    public static void main(String[] args) {
//        System.out.println(ConfigFileUrl.getUrlByKey("交易中心接口"));
//        System.out.println(SqlDetail.getTradeCenterPath("交易中心接口"));
//        System.out.println(SqlDetail.getTradeCenterPathId("交易中心接口"));
//        System.out.println(SqlDetail.getTradeCenterParamValue(0, "v"));
//        System.out.println(SqlDetail.getTradeCenterBuildEnabled().toString());
//        System.out.println(SqlDetail.getTradeCenterBuildMessageStatus().toString());
//        SqlDetail.updateTradeCenterPathErrnoCount(1);
//        SqlDetail.insertTradeCenterErrnoResult(1,"1,2,3", 1,"123");
//        SqlDetail.insertTradeCenterBuild(1, 0);
//        Message.sendMessage(SqlDetail.getParamValue(0, "mobile1"));
//        DingDing.push(SqlDetail.getParamValue(0, "mobile1"),
//                SqlDetail.getParamValue(0, "mobile2"),
//                SqlDetail.getParamValue(0, "mobile3"));

        Message.sendMessage("【中台】接口已经多次报错了，快去钉钉查看测试报告！！！",
                SqlDetail.getParamValue(0, "mobile1"),
                SqlDetail.getParamValue(0, "hsqAppId"));

    }
}
