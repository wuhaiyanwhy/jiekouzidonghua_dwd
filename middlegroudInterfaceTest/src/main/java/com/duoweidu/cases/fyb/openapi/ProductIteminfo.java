package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.TraverseConfig;
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
        Map<String, Object> mapData = TraverseConfig.traverseObj(model);
        Map<String, Object> mapAttrs = TraverseConfig.traverseCollection(model.attrs);
        Map<String, Object> mapAttrList = TraverseConfig.traverseCollection(model.attrList);
//        Map<String, Object> mapStocksList = TraverseConfig.traverseCollection(model.stocksList);
        Map<String, Object> mapBatchOptions = TraverseConfig.traverseCollection(model.batchOptions);
        Map<String, Object> mapMerchantInfo = TraverseConfig.traverseObj(model.merchantInfo);
        Map<String, Object> mapShareInfoFirendsZone = TraverseConfig.traverseObj(model.shareInfo.firendsZone);
        Map<String, Object> mapShareInfoWechat = TraverseConfig.traverseObj(model.shareInfo.wechat);
        Map<String, Object> mapShareInfoMobileQQ = TraverseConfig.traverseObj(model.shareInfo.mobileQQ);
        Map<String, Object> mapShareInfoAlipay = TraverseConfig.traverseObj(model.shareInfo.alipay);
        Map<String, Object> mapHasReturnList = TraverseConfig.traverseCollection(model.hasReturnList);

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
