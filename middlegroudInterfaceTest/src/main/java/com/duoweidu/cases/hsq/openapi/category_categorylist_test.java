package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CategoryCategorylistData;
import org.testng.annotations.Test;

public class category_categorylist_test extends HsqInterfaceTest {

    private CategoryCategorylistData model;

    @Test(description = "获取分类列表页")
    public void category_categorylist_true() {
        setUrl("category.categorylist.uri");
        param = "categoryId=0";
        process(true,true);
        model = sparseJson(CategoryCategorylistData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).name", model.list.get(i).name);
            detailAssertTest("list.get(i).thumbnail", model.list.get(i).thumbnail);
            detailAssertTest("list.get(i).subCategories", model.list.get(i).subCategories);
            for (int j = 0; j < model.list.get(i).subCategories.size(); j++) {
                detailAssertTest("list.get(i).subCategories.get(j).id", model.list.get(i).subCategories.get(j).id);
                detailAssertTest("list.get(i).subCategories.get(j).name", model.list.get(i).subCategories.get(j).name);
                detailAssertTest("list.get(i).subCategories.get(j).thumbnail", model.list.get(i).subCategories.get(j).thumbnail);
            }
        }

    }
}
