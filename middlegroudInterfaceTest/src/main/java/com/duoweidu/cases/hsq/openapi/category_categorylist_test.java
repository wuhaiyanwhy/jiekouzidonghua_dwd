package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class category_categorylist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取分类列表页")
    public void category_categorylist_true() {
        setUrl("category.categorylist.uri");
        param = "categoryId=0";
        process(true,true);
    }
}
