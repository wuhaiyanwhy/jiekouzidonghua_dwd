package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class CategorySearch extends FybInterfaceTest {

    @Test(description = "产品列表")
    public void categorySearch() {
        setUrl("category.Search.uri");
        param = "categoryId=1";
        process(true,false);
    }
}
