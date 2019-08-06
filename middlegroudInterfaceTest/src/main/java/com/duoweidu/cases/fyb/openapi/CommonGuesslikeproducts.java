package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommonGuesslikeproducts extends FybInterfaceTest {

    @Test(description = "获取商品列表")
    public void commonGuesslikeproducts() throws IOException {
        setUrl("common.guesslikeproducts.uri");
        param = "needPagination=1&pageNum=1&pageLimit=10";
        process(true,true);
    }
}
