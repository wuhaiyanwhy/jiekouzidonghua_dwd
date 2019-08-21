package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.TraverseConfig;
import com.duoweidu.model.fyb.CommonGuesslikeproductsModel;
import org.testng.annotations.Test;

import java.util.Map;

public class CommonGuesslikeproducts extends FybInterfaceTest {

    private CommonGuesslikeproductsModel model;

    @Test(description = "获取商品列表")
    public void commonGuesslikeproducts() {
        setUrl("common.guesslikeproducts.uri");
        param = "needPagination=1&pageNum=1&pageLimit=10";
        process(true,true);
        model = sparseJson(CommonGuesslikeproductsModel.class);
        detailAssert();

    }

    private void detailAssert() {

        Map<String, Object> mapObj = TraverseConfig.traverseObj(model);
        Map<String, Object> mapList = TraverseConfig.traverseCollection(model.list);
        for (Map.Entry<String, Object> entry : mapObj.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry : mapList.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            assertNotNull(entry.getKey(), entry.getValue());
        }


    }

}
