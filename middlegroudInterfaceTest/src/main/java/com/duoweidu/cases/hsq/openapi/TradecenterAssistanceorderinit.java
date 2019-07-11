package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.hsq.TradecenterAssistanceorderinitData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class TradecenterAssistanceorderinit extends HsqInterfaceTest {

    private TradecenterAssistanceorderinitData model;

    @Test(dependsOnGroups = "activityAssistanceeventdetail", description = "助力免单订单初始化", groups = "tradecenterAssistanceorderinit")
    public void tradecenterAssistanceorderinit() {
        setUrl("tradecenter.assistanceorderinit.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityId", SqlDetail.getParamValue(2, "noPayActivityId")));
        list.add(new BasicNameValuePair("activityEventId", String.valueOf(HsqOpenapiConfig.activityEventId)));
        list.add(new BasicNameValuePair("orderType", "7"));
        list.add(new BasicNameValuePair("amount", "1"));
        list.add(new BasicNameValuePair("token", SqlDetail.getParamValue("token")));
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(TradecenterAssistanceorderinitData.class);
            //储存接口返回数据
            HsqOpenapiConfig.activityConfirmSid = model.confirmSid;
            HsqOpenapiConfig.activityAddressId = model.address.id;
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest("address", model.address.toString());
        detailAssertTest("address.id", String.valueOf(model.address.id));
        detailAssertTest("address.province", model.address.province);
        detailAssertTest("address.city", model.address.city);
        detailAssertTest("address.district", model.address.district);
        detailAssertTest("address.contacter", model.address.contacter);
        detailAssertTest("address.detail_address", model.address.detail_address);
        detailAssertTest("address.mobile", model.address.mobile);
        detailAssertTest(0, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(139, "packageInfo.activityId", model.packageInfo.activityId);
        detailAssertTest(7, "packageInfo.orderType", model.packageInfo.orderType);
        detailAssertTest(0, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(616, "packageInfo.itemList.get(0).merchantId", model.packageInfo.itemList.get(0).merchantId);
        detailAssertTest("蜜我食铺", "packageInfo.itemList.get(0).merchantName", model.packageInfo.itemList.get(0).merchantName);
        detailAssertTest("haoshiqi://hybrid?compid=haoshiqi&comppage=merchant&merchantid=616", "packageInfo.itemList.get(0).schema", model.packageInfo.itemList.get(0).schema);
        detailAssertTest(0, "packageInfo.itemList.get(0).freeDeliveryPrice", model.packageInfo.itemList.get(0).freeDeliveryPrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).isFreeDelivery", model.packageInfo.itemList.get(0).isFreeDelivery);
        detailAssertTest(0, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(9999, "packageInfo.itemList.get(0).marketPrice", model.packageInfo.itemList.get(0).marketPrice);
        detailAssertTest(0, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest("packageInfo.itemList.get(0).activityEventId", String.valueOf(model.packageInfo.itemList.get(0).activityEventId));
        detailAssertTest(7, "packageInfo.itemList.get(0).orderType", model.packageInfo.itemList.get(0).orderType);
        detailAssertTest(34535, "packageInfo.itemList.get(0).skuList.get(0).id", model.packageInfo.itemList.get(0).skuList.get(0).id);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).source_type", model.packageInfo.itemList.get(0).skuList.get(0).source_type);
        detailAssertTest(616, "packageInfo.itemList.get(0).skuList.get(0).merchant_id", model.packageInfo.itemList.get(0).skuList.get(0).merchant_id);
        detailAssertTest(28745, "packageInfo.itemList.get(0).skuList.get(0).product_id", model.packageInfo.itemList.get(0).skuList.get(0).product_id);
        detailAssertTest("接口自动化测试专用助力免单 100g", "packageInfo.itemList.get(0).skuList.get(0).name", model.packageInfo.itemList.get(0).skuList.get(0).name);
        detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).weight", model.packageInfo.itemList.get(0).skuList.get(0).weight);
        detailAssertTest(8888, "packageInfo.itemList.get(0).skuList.get(0).price", model.packageInfo.itemList.get(0).skuList.get(0).price);
        detailAssertTest("http://img2.haoshiqi.net/ma83cfe38517bb7812d3562f7d1486f3e1.jpg?imageView2/0/w/200/h/200/q/70", "packageInfo.itemList.get(0).skuList.get(0).thumbnail", model.packageInfo.itemList.get(0).skuList.get(0).thumbnail);
        detailAssertTest(9999, "packageInfo.itemList.get(0).skuList.get(0).market_price", model.packageInfo.itemList.get(0).skuList.get(0).market_price);
        detailAssertTest(8888, "packageInfo.itemList.get(0).skuList.get(0).lowest_price", model.packageInfo.itemList.get(0).skuList.get(0).lowest_price);
        detailAssertTest(1559543748, "packageInfo.itemList.get(0).skuList.get(0).seller_time", model.packageInfo.itemList.get(0).skuList.get(0).seller_time);
        detailAssertTest(1909065600, "packageInfo.itemList.get(0).skuList.get(0).expired_date", model.packageInfo.itemList.get(0).skuList.get(0).expired_date);
        detailAssertTest("2000-01-01", "packageInfo.itemList.get(0).skuList.get(0).manufactured_date", model.packageInfo.itemList.get(0).skuList.get(0).manufactured_date);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).enabled", model.packageInfo.itemList.get(0).skuList.get(0).enabled);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).actived", model.packageInfo.itemList.get(0).skuList.get(0).actived);
        detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).delete_flag", model.packageInfo.itemList.get(0).skuList.get(0).delete_flag);
        detailAssertTest(2, "packageInfo.itemList.get(0).skuList.get(0).audit_status", model.packageInfo.itemList.get(0).skuList.get(0).audit_status);
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).restriction_amount", String.valueOf(model.packageInfo.itemList.get(0).skuList.get(0).restriction_amount));
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).fpostage_amount", String.valueOf(model.packageInfo.itemList.get(0).skuList.get(0).fpostage_amount));
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).online_time", model.packageInfo.itemList.get(0).skuList.get(0).online_time);
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).only_new_user", String.valueOf(model.packageInfo.itemList.get(0).skuList.get(0).only_new_user));
        detailAssertTest("pin", "packageInfo.itemList.get(0).skuList.get(0).feature", model.packageInfo.itemList.get(0).skuList.get(0).feature);
        detailAssertTest(9999, "packageInfo.itemList.get(0).skuList.get(0).lowest_web_price", model.packageInfo.itemList.get(0).skuList.get(0).lowest_web_price);
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).version_id", String.valueOf(model.packageInfo.itemList.get(0).skuList.get(0).version_id));
        detailAssertTest("规格", "packageInfo.itemList.get(0).skuList.get(0).attrs.get(0).name", String.valueOf(model.packageInfo.itemList.get(0).skuList.get(0).attrs.get(0).name));
        detailAssertTest("100g", "packageInfo.itemList.get(0).skuList.get(0).attrs.get(0).value", String.valueOf(model.packageInfo.itemList.get(0).skuList.get(0).attrs.get(0).value));
        detailAssertTest("1", "packageInfo.itemList.get(0).skuList.get(0).sku_order_amount", model.packageInfo.itemList.get(0).skuList.get(0).sku_order_amount);
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).offline_before_expired", model.packageInfo.itemList.get(0).skuList.get(0).offline_before_expired);
        detailAssertTest(616, "packageInfo.itemList.get(0).skuList.get(0).merchantId", model.packageInfo.itemList.get(0).skuList.get(0).merchantId);
        detailAssertTest(true, "packageInfo.itemList.get(0).skuList.get(0).canDelivery", model.packageInfo.itemList.get(0).skuList.get(0).canDelivery);
        detailAssertTest(139, "packageInfo.itemList.get(0).skuList.get(0).activityId", model.packageInfo.itemList.get(0).skuList.get(0).activityId);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).dealAmount", model.packageInfo.itemList.get(0).skuList.get(0).dealAmount);
        detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).orderPrice", model.packageInfo.itemList.get(0).skuList.get(0).orderPrice);
        detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).dealPrice", model.packageInfo.itemList.get(0).skuList.get(0).dealPrice);
        detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).totalPrice", model.packageInfo.itemList.get(0).skuList.get(0).totalPrice);
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).leftStock", model.packageInfo.itemList.get(0).skuList.get(0).leftStock);
        detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).left_stock", model.packageInfo.itemList.get(0).skuList.get(0).left_stock);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).orderAmount", model.packageInfo.itemList.get(0).skuList.get(0).orderAmount);
        detailAssertTest(34535, "packageInfo.itemList.get(0).skuList.get(0).skuId", model.packageInfo.itemList.get(0).skuList.get(0).skuId);
        detailAssertTest("接口自动化测试专用助力免单 100g", "packageInfo.itemList.get(0).skuList.get(0).sku_name", model.packageInfo.itemList.get(0).skuList.get(0).sku_name);
        detailAssertTest("规格", "packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(0).name", model.packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(0).name);
        detailAssertTest("100g", "packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(0).value", model.packageInfo.itemList.get(0).skuList.get(0).attribute_tags.get(0).value);

        detailAssertTest(28745, "packageInfo.itemList.get(0).skuList.get(0).productId", model.packageInfo.itemList.get(0).skuList.get(0).productId);
        detailAssertTest("http://img2.haoshiqi.net/ma83cfe38517bb7812d3562f7d1486f3e1.jpg?imageView2/0/w/200/h/200/q/70", "packageInfo.itemList.get(0).skuList.get(0).skuThumbnail", model.packageInfo.itemList.get(0).skuList.get(0).skuThumbnail);
        detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).platformDiscount", model.packageInfo.itemList.get(0).skuList.get(0).platformDiscount);
        detailAssertTest("haoshiqi://hybrid?compid=haoshiqi&comppage=zl_detail&id=139", "packageInfo.itemList.get(0).skuList.get(0).schema", model.packageInfo.itemList.get(0).skuList.get(0).schema);
        detailAssertTest(0, "packageInfo.itemList.get(0).discountPrice", model.packageInfo.itemList.get(0).discountPrice);
        detailAssertTest(0, "packageInfo.itemList.get(0).platformDiscount", model.packageInfo.itemList.get(0).platformDiscount);
        detailAssertTest(32767, "packageInfo.itemList.get(0).join_times_limit", model.packageInfo.itemList.get(0).join_times_limit);
        detailAssertTest(1, "paymentway.get(0).id", model.paymentway.get(0).id);
        detailAssertTest("微信支付", "paymentway.get(0).name", model.paymentway.get(0).name);
        detailAssertTest("http://img2.haoshiqi.net/wechatpay.png", "paymentway.get(0).icon", model.paymentway.get(0).icon);
        detailAssertTest("confirmSid", model.confirmSid);



    }
}
