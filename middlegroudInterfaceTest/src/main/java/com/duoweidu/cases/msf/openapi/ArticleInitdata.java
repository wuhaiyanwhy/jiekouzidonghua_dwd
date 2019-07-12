package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ArticleInitdata extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "发布页初始化")
    public void articleInitdata() {
        setUrl("article.initdata.uri");
        param = "order_id=" + SqlDetail.getParamValue("order_id");
        process(true,false);
    }
}
