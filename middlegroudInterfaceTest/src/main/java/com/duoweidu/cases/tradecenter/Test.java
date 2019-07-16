package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.message.Message;
import com.duoweidu.config.sql.SqlDetail;

public class Test {

    public static void main(String[] args) {
//        System.out.println(ConfigFileUrl.getUrlByKey("交易中心接口"));
//        System.out.println(SqlDetail.getInstance().getTradeCenterPath("交易中心接口"));
//        System.out.println(SqlDetail.getInstance().getTradeCenterPathId("交易中心接口"));
//        System.out.println(SqlDetail.getInstance().getTradeCenterParamValue(0, "v"));
//        System.out.println(SqlDetail.getInstance().getTradeCenterBuildEnabled().toString());
//        System.out.println(SqlDetail.getInstance().getTradeCenterBuildMessageStatus().toString());
//        SqlDetail.getInstance().updateTradeCenterPathErrnoCount(1);
//        SqlDetail.getInstance().insertTradeCenterErrnoResult(1,"1,2,3", 1,"123");
//        SqlDetail.getInstance().insertTradeCenterBuild(1, 0);
//        Message.sendMessage(SqlDetail.getInstance().getParamValue(0, "mobile1"));
//        DingDing.push(SqlDetail.getInstance().getParamValue(0, "mobile1"),
//                SqlDetail.getInstance().getParamValue(0, "mobile2"),
//                SqlDetail.getInstance().getParamValue(0, "mobile3"));

        Message.sendMessage("【中台】接口已经多次报错了，快去钉钉查看测试报告！！！",
                SqlDetail.getInstance().getParamValue(0, "mobile1"),
                SqlDetail.getInstance().getParamValue(0, "hsqAppId"));

    }
}
