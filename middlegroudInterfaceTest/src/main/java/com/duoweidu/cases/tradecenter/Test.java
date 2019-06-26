package com.duoweidu.cases.tradecenter;

import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.utils.ConfigFileUrl;

public class Test {

    public static void main(String[] args) {
//        System.out.println(ConfigFileUrl.getUrlByKey("交易中心接口"));
//        System.out.println(SqlTradecenter.getTradeCenterPath("交易中心接口"));
//        System.out.println(SqlTradecenter.getTradeCenterPathId("交易中心接口"));
//        System.out.println(SqlTradecenter.getTradeCenterParamValue(0, "v"));
//        System.out.println(SqlTradecenter.getTradeCenterBuildEnabled().toString());
//        System.out.println(SqlTradecenter.getTradeCenterBuildMessageStatus().toString());
//        SqlTradecenter.updateTradeCenterPathErrnoCount(1);
        SqlTradecenter.insertTradeCenterErrnoResult(1,"1,2,3", 1,"123");
        SqlTradecenter.insertTradeCenterBuild(1, 0);


    }
}
