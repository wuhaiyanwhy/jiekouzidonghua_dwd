package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.CategorySearchData;
import org.testng.annotations.Test;

public class CategorySearch extends FybInterfaceTest {

    private CategorySearchData model;

    @Test(description = "产品列表")
    public void categorySearch() {
        setUrl("category.Search.uri");
        param = "categoryId=1";
        process(true,false);
        model = sparseJson(CategorySearchData.class);
//        detailAssert();
    }

//    private void detailAssert() {
//        for (int i = 0; i < model.list.size(); i++) {
//            assertNotNull("list.get(i).id", model.list.get(i).id);
//            assertNotNull("list.get(i).name", model.list.get(i).name);
//            assertNotNull("list.get(i).main_sku", model.list.get(i).main_sku);
//            assertNotNull("list.get(i).main_sku_pic", model.list.get(i).main_sku_pic);
//            assertNotNull("list.get(i).left_stock", model.list.get(i).left_stock);
//            assertNotNull("list.get(i).locked_stock", model.list.get(i).locked_stock);
//            assertNotNull("list.get(i).thumbnail", model.list.get(i).thumbnail);
//            assertNotNull("list.get(i).market_price", model.list.get(i).market_price);
//            assertNotNull("list.get(i).reversion", model.list.get(i).reversion);
//            assertNotNull("list.get(i).deduction", model.list.get(i).deduction);
//            assertNotNull("list.get(i).selled_cnt", model.list.get(i).selled_cnt);
//            assertNotNull("list.get(i).price", model.list.get(i).price);
//
//        }

//    }
}
