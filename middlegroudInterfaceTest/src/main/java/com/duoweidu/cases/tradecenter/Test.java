package com.duoweidu.cases.tradecenter;

import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.utils.ConfigFileUrl;

public class Test {

    public static void main(String[] args) {
        System.out.println(ConfigFileUrl.getUrlByKey("交易中心接口"));
        System.out.println(SqlTradecenter.getTradeCenterPath("交易中心接口"));
    }
}
