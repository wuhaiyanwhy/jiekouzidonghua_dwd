package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ProductHotkeysearch extends FybInterfaceTest {

    @Test(description = "商品搜索")
    public void productHotkeysearch() {
        setUrl("product.hotkeysearch.uri");
        param = "q=" + SqlDetail.getInstance().getParamValue(0, "q")  +
                "&sort=asc&sortType=id&needPagination=1&pageNum=1&pageLimit=20";
        process(true,true);
    }
}
