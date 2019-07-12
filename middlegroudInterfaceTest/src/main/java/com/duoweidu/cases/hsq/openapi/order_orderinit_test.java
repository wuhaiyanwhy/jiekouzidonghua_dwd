package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderOrderinitData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_orderinit_test extends HsqInterfaceTest {

    private OrderOrderinitData model;

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（普通）",groups = "orderinitPutong")
    public void order_orderinit_putongTrue() {
        setUrl("order.orderinit.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skusInfo","[{\"skuId\":\""+ SqlDetail.getParamValue("skuId")
                + "\",\"amount\":\"1\",\"price\":\""+ SqlDetail.getParamValue("price") + "\"}]"));
        list.add(new BasicNameValuePair("conformNewUser","1"));
        process(list,true,false);
        HsqOpenapiConfig.orderinitResult = result;
    }

    @Test(description = "初始化订单（信用购）",groups = "orderinitXinyonggou")
    public void orderOrderinitXinyonggou() {
        setUrl("order.orderinit.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType", "11"));
        list.add(new BasicNameValuePair("amount", "1"));
        list.add(new BasicNameValuePair("zhimaSkuId", SqlDetail.getParamValue(2, "zhimaId")));
        list.add(new BasicNameValuePair("token", SqlDetail.getParamValue("token")));
        process(list,false,false);

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(OrderOrderinitData.class);
            xinyongDetailAssert();
            HsqOpenapiConfig.orderInitResult = result;
            HsqOpenapiConfig.xinyongConfirmSid = model.confirmSid;
            HsqOpenapiConfig.xinyongAddressId = model.address.id;
        }

    }

    private void xinyongDetailAssert() {
        detailAssertTest("confirmSid", model.confirmSid);
        detailAssertTest(true, "orderAvailable", model.orderAvailable);
        detailAssertTest("paymentway", model.paymentway);
        detailAssertTest(1, "paymentway.get(0).id", model.paymentway.get(0).id);
        detailAssertTest("微信支付", "paymentway.get(0).name", model.paymentway.get(0).name);
        detailAssertTest("http://img2.haoshiqi.net/wechatpay.png", "paymentway.get(0).icon", model.paymentway.get(0).icon);

        detailAssertTest("packageInfo", model.packageInfo.toString());
        detailAssertTest(0, "packageInfo.platformDiscount", model.packageInfo.platformDiscount);
        detailAssertTest(11, "packageInfo.orderType", model.packageInfo.orderType);
        detailAssertTest(10999, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);

        detailAssertTest("packageInfo.itemList", model.packageInfo.itemList);
        detailAssertTest("蜜我食铺", "packageInfo.itemList.get(0).merchantName", model.packageInfo.itemList.get(0).merchantName);
        detailAssertTest(616, "packageInfo.itemList.get(0).merchantId", model.packageInfo.itemList.get(0).merchantId);
        detailAssertTest(11, "packageInfo.itemList.get(0).orderType", model.packageInfo.itemList.get(0).orderType);
        detailAssertTest("haoshiqi://com.doweidu/merchant?merchantId=616", "packageInfo.itemList.get(0).schema", model.packageInfo.itemList.get(0).schema);
        detailAssertTest(10999, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest("packageInfo.itemList.get(0).skuList", model.packageInfo.itemList.get(0).skuList);
        detailAssertTest(34548, "packageInfo.itemList.get(0).skuList.get(0).id", model.packageInfo.itemList.get(0).skuList.get(0).id);
        detailAssertTest("接口自动化测试专用商品（勿动） 100g", "packageInfo.itemList.get(0).skuList.get(0).name", model.packageInfo.itemList.get(0).skuList.get(0).name);
        detailAssertTest("http://img2.haoshiqi.net/ma775648f49d5b7fc726fbe01d8a2325f2.jpg", "packageInfo.itemList.get(0).skuList.get(0).thumbnail", model.packageInfo.itemList.get(0).skuList.get(0).thumbnail);
        detailAssertTest(10999, "packageInfo.itemList.get(0).skuList.get(0).market_price", model.packageInfo.itemList.get(0).skuList.get(0).market_price);
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).left_stock", model.packageInfo.itemList.get(0).skuList.get(0).left_stock);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).orderAmount", model.packageInfo.itemList.get(0).skuList.get(0).orderAmount);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).dealAmount", model.packageInfo.itemList.get(0).skuList.get(0).dealAmount);
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).attribute_tags", model.packageInfo.itemList.get(0).skuList.get(0).attribute_tags);
        detailAssertTest("规格", "packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(0).name", model.packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(0).name);
        detailAssertTest("100g", "packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(0).value", model.packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(0).value);
        detailAssertTest("批次", "packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(1).name", model.packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(1).name);
        detailAssertTest("2537539200", "packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(1).value", model.packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(1).value);
        detailAssertTest(true, "packageInfo.itemList.get(0).skuList.get(0).canDelivery", model.packageInfo.itemList.get(0).skuList.get(0).canDelivery);
        detailAssertTest(false, "packageInfo.itemList.get(0).skuList.get(0).outOfStock", model.packageInfo.itemList.get(0).skuList.get(0).outOfStock);
        detailAssertTest("http://img2.haoshiqi.net/ma775648f49d5b7fc726fbe01d8a2325f2.jpg", "packageInfo.itemList.get(0).skuList.get(0).skuThumbnail", model.packageInfo.itemList.get(0).skuList.get(0).skuThumbnail);
        detailAssertTest(28755, "packageInfo.itemList.get(0).skuList.get(0).product_id", model.packageInfo.itemList.get(0).skuList.get(0).product_id);
        detailAssertTest(10999, "packageInfo.itemList.get(0).skuList.get(0).price", model.packageInfo.itemList.get(0).skuList.get(0).price);
        detailAssertTest(10999, "packageInfo.itemList.get(0).skuList.get(0).orderPrice", model.packageInfo.itemList.get(0).skuList.get(0).orderPrice);
        detailAssertTest(10999, "packageInfo.itemList.get(0).skuList.get(0).totalPrice", model.packageInfo.itemList.get(0).skuList.get(0).totalPrice);

        detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(76, "packageInfo.zhimaId", model.packageInfo.zhimaId);

        detailAssertTest(1902, "address.id", model.address.id);
        detailAssertTest("北京", "address.province", model.address.province);
        detailAssertTest("北京市", "address.city", model.address.city);
        detailAssertTest("东城区", "address.district", model.address.district);
        detailAssertTest("红红", "address.contacter", model.address.contacter);
        detailAssertTest("110101", "address.detail_address", model.address.detail_address);
        detailAssertTest("130****6002", "address.mobile", model.address.mobile);

    }

}
