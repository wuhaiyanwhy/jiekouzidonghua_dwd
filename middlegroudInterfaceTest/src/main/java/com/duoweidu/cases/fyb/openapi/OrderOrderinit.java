package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.fyb.OrderOrderinitData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderOrderinit extends FybInterfaceTest {

    private OrderOrderinitData model;

    @Test(description = "订单初始化",groups = "orderOrderinit")
    public void orderOrderinit() {
        setUrl("order.orderinit.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skusInfo","[{\"skuId\":"+ SqlDetail.getInstance().getParamValue("skuId") +
                ",\"amount\":1,\"price\":" + SqlDetail.getInstance().getParamValue("price") + "}]"));
        process(list,true,false);
        FybConfig.orderinitResult = result;
        model =sparseJson(OrderOrderinitData.class);
        detailAssert();

    }

    private void detailAssert() {
        assertNotEmpty("packageInfo.totalPrice", model.packageInfo.totalPrice);
        assertNotEmpty("packageInfo.totalAmount", model.packageInfo.totalAmount);
        assertNotEmpty("packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        assertNotEmpty("packageInfo.itemList", model.packageInfo.itemList);
        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {
            assertNotEmpty("packageInfo.itemList.get(i).merchantId", model.packageInfo.itemList.get(i).merchantId);
            assertNotNull("packageInfo.itemList.get(i).freeDeliveryPrice", model.packageInfo.itemList.get(i).freeDeliveryPrice);
            assertNotEmpty("packageInfo.itemList.get(i).isFreeDelivery", model.packageInfo.itemList.get(i).isFreeDelivery);
            assertNotEmpty("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice);
            assertNotEmpty("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount);
            assertNotEmpty("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice);
            assertNotEmpty("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice);
            assertNotEmpty("packageInfo.itemList.get(i).delivery_fee_way", model.packageInfo.itemList.get(i).delivery_fee_way);
            assertNotEmpty("packageInfo.itemList.get(i).isDeliveryFree", model.packageInfo.itemList.get(i).isDeliveryFree);
            assertNotEmpty("packageInfo.itemList.get(i).skuList", model.packageInfo.itemList.get(i).skuList);
            for (int j = 0; j < model.packageInfo.itemList.get(i).skuList.size(); j++) {
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).id", model.packageInfo.itemList.get(i).skuList.get(j).id);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).id", model.packageInfo.itemList.get(i).skuList.get(j).id);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).product_id", model.packageInfo.itemList.get(i).skuList.get(j).product_id);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).sku_name", model.packageInfo.itemList.get(i).skuList.get(j).sku_name);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).market_price", model.packageInfo.itemList.get(i).skuList.get(j).market_price);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).total_price", model.packageInfo.itemList.get(i).skuList.get(j).total_price);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).created_at", model.packageInfo.itemList.get(i).skuList.get(j).created_at);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).updated_at", model.packageInfo.itemList.get(i).skuList.get(j).updated_at);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).source_type", model.packageInfo.itemList.get(i).skuList.get(j).source_type);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).skuId", model.packageInfo.itemList.get(i).skuList.get(j).skuId);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).name", model.packageInfo.itemList.get(i).skuList.get(j).name);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).skuThumbnail", model.packageInfo.itemList.get(i).skuList.get(j).skuThumbnail);
                assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).productId", model.packageInfo.itemList.get(i).skuList.get(j).productId);

                for (int k = 0; k < model.packageInfo.itemList.get(i).skuList.get(j).attribute_tags.size(); k++) {
                    assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).attribute_tags.get(k).name", model.packageInfo.itemList.get(i).skuList.get(j).attribute_tags.get(k).name);
                    assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).attribute_tags.get(k).value", model.packageInfo.itemList.get(i).skuList.get(j).attribute_tags.get(k).value);

                }


            }
        }

    }
}
