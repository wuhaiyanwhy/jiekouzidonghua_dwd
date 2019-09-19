package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.utils.TraverseResult;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.fyb.ProductIteminfoData;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductIteminfo extends FybInterfaceTest {

    private ProductIteminfoData model;

    @Test(description = "产品详情")
    public void productIteminfo() {
        setUrl("product.iteminfo.uri");
        param = "skuId=" + SqlDetail.getInstance().getParamValue("skuId");
        process(true,false);
        model = sparseJson(ProductIteminfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseResult.traverseObj(model);
        Map<String, Object> mapAttrs = TraverseResult.traverseCollection(model.attrs);
        Map<String, Object> mapAttrList = TraverseResult.traverseCollection(model.attrList);
//        Map<String, Object> mapStocksList = TraverseResult.traverseCollection(model.stocksList);
        Map<String, Object> mapBatchOptions = TraverseResult.traverseCollection(model.batchOptions);
        Map<String, Object> mapMerchantInfo = TraverseResult.traverseObj(model.merchantInfo);
        Map<String, Object> mapShareInfoFirendsZone = TraverseResult.traverseObj(model.shareInfo.firendsZone);
        Map<String, Object> mapShareInfoWechat = TraverseResult.traverseObj(model.shareInfo.wechat);
        Map<String, Object> mapShareInfoMobileQQ = TraverseResult.traverseObj(model.shareInfo.mobileQQ);
        Map<String, Object> mapShareInfoAlipay = TraverseResult.traverseObj(model.shareInfo.alipay);
        Map<String, Object> mapHasReturnList = TraverseResult.traverseCollection(model.hasReturnList);

        for (Map.Entry<String, Object> entry:
                mapData.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapAttrs.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapAttrList.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
//        for (Map.Entry<String, Object> entry:
//                mapStocksList.entrySet()) {
//            assertNotNull(entry.getKey(), entry.getValue());
//        }
        for (Map.Entry<String, Object> entry:
                mapBatchOptions.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapMerchantInfo.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapShareInfoFirendsZone.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapShareInfoWechat.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapShareInfoMobileQQ.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapShareInfoAlipay.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry:
                mapHasReturnList.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

    }
}
