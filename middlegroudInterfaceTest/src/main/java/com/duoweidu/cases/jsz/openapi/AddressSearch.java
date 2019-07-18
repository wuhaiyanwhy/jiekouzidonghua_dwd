package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class AddressSearch extends JszInterfaceTest{

    @Test(dependsOnGroups = "UserLogincallback",description = "地址搜索")
    public void addressSearch() {
        setUrl("address.search.uri");
        param = "keyword=" + SqlDetail.getInstance().getParamValue("keyword") +
                "&city=" + SqlDetail.getInstance().getParamValue("city") ;
        process(true, false);
    }
}
