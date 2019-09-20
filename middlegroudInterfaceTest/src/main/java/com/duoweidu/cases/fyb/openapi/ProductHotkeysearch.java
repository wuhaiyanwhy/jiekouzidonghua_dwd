package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.fyb.ProductHotkeysearchData;
import org.testng.annotations.Test;

public class ProductHotkeysearch extends FybInterfaceTest {

    private ProductHotkeysearchData model;

    @Test(description = "商品搜索")
    public void productHotkeysearch() {
        setUrl("product.hotkeysearch.uri");
        param = "q=" + SqlDetail.getInstance().getParamValue(0, "q")  +
                "&sort=asc&sortType=id&needPagination=1&pageNum=1&pageLimit=20";
        process(true,true);
        model = sparseJson(ProductHotkeysearchData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("totalCnt", model.totalCnt);
        assertNotEmpty("totalPage", model.totalPage);
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).name", model.list.get(i).name);
            assertNotEmpty("list.get(i).main_sku", model.list.get(i).main_sku);
            assertNotEmpty("list.get(i).main_sku_pic", model.list.get(i).main_sku_pic);
            assertNotNull("list.get(i).left_stock", model.list.get(i).left_stock);
            assertNotNull("list.get(i).locked_stock", model.list.get(i).locked_stock);
            assertNotEmpty("list.get(i).thumbnail", model.list.get(i).thumbnail);
            assertNotEmpty("list.get(i).market_price", model.list.get(i).market_price);
            assertNotEmpty("list.get(i).price", model.list.get(i).price);
            assertNotNull("list.get(i).reversion", model.list.get(i).reversion);
            assertNotEmpty("list.get(i).deduction", model.list.get(i).deduction);
            assertNotNull("list.get(i).selled_cnt", model.list.get(i).selled_cnt);

        }

    }
}
