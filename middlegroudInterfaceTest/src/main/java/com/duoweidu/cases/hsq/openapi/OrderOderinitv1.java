package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderOderinitv1Data;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderOderinitv1 extends HsqInterfaceTest {

    private OrderOderinitv1Data model;

    private void getRequest(List<NameValuePair> list) {
        setUrl("order.orderinit_v1.uri");
        process(list,true,false);
        model = sparseJson(OrderOderinitv1Data.class);
    }

    @Test(dependsOnGroups = "editsku" ,description = "普通订单初始化",groups = "oderinit")
    public void orderOderinitv1(){
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skusInfo","[{\"skuId\":\""+ SqlDetail.getInstance().getParamValue("gonewskuId")
                + "\",\"amount\":\"1\",\"price\":\""+ SqlDetail.getInstance().getParamValue("goprice") + "\"}]"));
        list.add(new BasicNameValuePair("isFastbuy", "0"));
        System.out.println(list.toString());
        getRequest(list);
        HsqOpenapiConfig.goconfirmSid = model.confirmSid;
        detailAssert();
    }

    @Test(dependsOnGroups = "addskutocartMerchant" ,description = "普通订单初始化（只有商家优惠，2件 + 商家优惠券）",groups = "oderinitMerchant")
    public void orderOderinitv1Merchant(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("merchantSkuId")
                    + "\",\"amount\":\"2\",\"price\":\"" + SqlDetail.getInstance().getParamValue("merchantPrice") + "\"}]"));
            getRequest(list);
            HsqOpenapiConfig.merchantConfirmSid = model.confirmSid;
            merchantAssert();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠减钱第二件，未达到优惠条件+商家券+平台券）",groups = "oderinitNoLose2")
    public void orderOderinitv1Nolose2(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("loseSkuId2")
                    + "\",\"amount\":\"1\",\"price\":\"" + SqlDetail.getInstance().getParamValue("losePrice2") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            System.out.println(list.toString());
            getRequest(list);
            HsqOpenapiConfig.confirmSidNoLose2 = model.confirmSid;
            assertNoLose2();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠减钱第二件，达到优惠条件+商家券+平台券）",groups = "oderinitLose2")
    public void orderOderinitv1lose2(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("loseSkuId2")
                    + "\",\"amount\":\"2\",\"price\":\"" + SqlDetail.getInstance().getParamValue("losePrice2") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            System.out.println(list.toString());
            getRequest(list);
            HsqOpenapiConfig.confirmSidLose2 = model.confirmSid;
            assertLose2();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠减钱 23，商家券）",groups = "oderinitLose23")
    public void orderOderinitv1lose23(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("loseSkuId23")
                    + "\",\"amount\":\"3\",\"price\":\"" + SqlDetail.getInstance().getParamValue("losePrice23") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            System.out.println(list.toString());
            getRequest(list);
            HsqOpenapiConfig.confirmSidLose23 = model.confirmSid;
            assertLose23();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠减钱 24，商家券）",groups = "oderinitLose24")
    public void orderOderinitv1lose24(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("loseSkuId24")
                    + "\",\"amount\":\"4\",\"price\":\"" + SqlDetail.getInstance().getParamValue("losePrice24") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            System.out.println(list.toString());
            getRequest(list);
            HsqOpenapiConfig.confirmSidLose24 = model.confirmSid;
            assertLose24();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠减钱 235，商家券）",groups = "oderinitLose235")
    public void orderOderinitv1lose235(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("loseSkuId235")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("losePrice235") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidLose235 = model.confirmSid;
            assertLose235();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠打折 3，商家券）",groups = "oderinitDiscount3")
    public void orderOderinitv1Discount3(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("discountSkuId3")
                    + "\",\"amount\":\"3\",\"price\":\"" + SqlDetail.getInstance().getParamValue("discountPrice3") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidDiscount3 = model.confirmSid;
            assertDiscount3();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠打折 34，商家券）",groups = "oderinitDiscount34")
    public void orderOderinitv1Discount34(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("discountSkuId34")
                    + "\",\"amount\":\"4\",\"price\":\"" + SqlDetail.getInstance().getParamValue("discountPrice34") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidDiscount34 = model.confirmSid;
            assertDiscount34();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠打折 35，商家券+平台券）",groups = "oderinitDiscount35")
    public void orderOderinitv1Discount35(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("discountSkuId35")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("discountPrice35") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidDiscount35 = model.confirmSid;
            assertDiscount35();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠打折 245，商家券）",groups = "oderinitDiscount245")
    public void orderOderinitv1Discount245(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("discountSkuId245")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("discountPrice245") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidDiscount245 = model.confirmSid;
            assertDiscount245();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠打折 2345，商家券）",groups = "oderinitDiscount2345")
    public void orderOderinitv1Discount2345(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("discountSkuId2345")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("discountPrice2345") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidDiscount2345 = model.confirmSid;
            assertDiscount2345();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠付钱 5，商家券）",groups = "oderinitPay5")
    public void orderOderinitv1Pay5(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("paySkuId5")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("payPrice5") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidPay5 = model.confirmSid;
            assertPay5();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠付钱 45，商家券）",groups = "oderinitPay45")
    public void orderOderinitv1Pay45(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("paySkuId45")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("payPrice45") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidPay45 = model.confirmSid;
            assertPay45();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠付钱 25，商家券）",groups = "oderinitPay25")
    public void orderOderinitv1Pay25(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("paySkuId25")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("payPrice25") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidPay25 = model.confirmSid;
            assertPay25();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠付钱 345，商家券）",groups = "oderinitPay235")
    public void orderOderinitv1Pay345(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("paySkuId345")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("payPrice345") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidPay345 = model.confirmSid;
            assertPay345();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(description = "普通订单初始化（多件优惠付钱 2345，商家券+平台券）",groups = "oderinitPay2345")
    public void orderOderinitv1Pay2345(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("skusInfo", "[{\"skuId\":\"" + SqlDetail.getInstance().getParamValue("paySkuId2345")
                    + "\",\"amount\":\"5\",\"price\":\"" + SqlDetail.getInstance().getParamValue("payPrice2345") + "\"}]"));
            list.add(new BasicNameValuePair("isFastbuy", "1"));
            getRequest(list);
            HsqOpenapiConfig.confirmSidPay2345 = model.confirmSid;
            assertPay2345();
        }else {
            System.out.println("此环境无此case");
        }
    }

    private void detailAssert() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 10000);
            assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 1);
            assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 10000);
            for (int i = 0; i < model.packageInfo.itemList.size(); i++) {
                assertEquals("packageInfo.itemList.get(i).merchant_id", model.packageInfo.itemList.get(i).merchant_id, 139);
                assertEquals("packageInfo.itemList.get(i).merchant_name", model.packageInfo.itemList.get(i).merchant_name, "华鸣电商");
                assertNotNull("packageInfo.itemList.get(i).icon", model.packageInfo.itemList.get(i).icon);
                assertEquals("packageInfo.itemList.get(i).freeDeliveryPrice", model.packageInfo.itemList.get(i).freeDeliveryPrice, 0);
                assertEquals("packageInfo.itemList.get(i).isFreeDelivery", model.packageInfo.itemList.get(i).isFreeDelivery, 1);
                assertEquals("packageInfo.itemList.get(i).isFreeBaseWeight", model.packageInfo.itemList.get(i).isFreeBaseWeight, 1);
                assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 10000);
                assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 1);
                assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 10000);
                assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 10000);
                assertEquals("packageInfo.itemList.get(i).totalWeight", model.packageInfo.itemList.get(i).totalWeight, 0);
                assertEquals("packageInfo.itemList.get(i).totalWeightSum", model.packageInfo.itemList.get(i).totalWeightSum, 0);
                for (int j = 0; j < model.packageInfo.itemList.get(i).skuList.size(); j++) {
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).id", model.packageInfo.itemList.get(i).skuList.get(j).id, 34573);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).merchant_id", model.packageInfo.itemList.get(i).skuList.get(j).merchant_id, 139);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).product_id", model.packageInfo.itemList.get(i).skuList.get(j).product_id, 28776);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).name", model.packageInfo.itemList.get(i).skuList.get(j).name, "最后一遍流程 测试");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).weight", model.packageInfo.itemList.get(i).skuList.get(j).weight, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).price", model.packageInfo.itemList.get(i).skuList.get(j).price, 10000);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).thumbnail", model.packageInfo.itemList.get(i).skuList.get(j).thumbnail);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).market_price", model.packageInfo.itemList.get(i).skuList.get(j).market_price, 10000);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).lowest_price", model.packageInfo.itemList.get(i).skuList.get(j).lowest_price, 10000);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).seller_time", model.packageInfo.itemList.get(i).skuList.get(j).seller_time, 1561623179);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).expired_date", model.packageInfo.itemList.get(i).skuList.get(j).expired_date, "1579622400");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).manufactured_date", model.packageInfo.itemList.get(i).skuList.get(j).manufactured_date, "2018-12-18");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).enabled", model.packageInfo.itemList.get(i).skuList.get(j).enabled, 1);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).liked_cnt", model.packageInfo.itemList.get(i).skuList.get(j).liked_cnt);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).ugc_cnt", model.packageInfo.itemList.get(i).skuList.get(j).ugc_cnt);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).selled_cnt", model.packageInfo.itemList.get(i).skuList.get(j).selled_cnt);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).merchant_item_code", model.packageInfo.itemList.get(i).skuList.get(j).merchant_item_code);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).actived", model.packageInfo.itemList.get(i).skuList.get(j).actived, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).delete_flag", model.packageInfo.itemList.get(i).skuList.get(j).delete_flag, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).created_at", model.packageInfo.itemList.get(i).skuList.get(j).created_at, 1561623044);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).updated_at", model.packageInfo.itemList.get(i).skuList.get(j).updated_at);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).audit_status", model.packageInfo.itemList.get(i).skuList.get(j).audit_status, 2);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).audit_time", model.packageInfo.itemList.get(i).skuList.get(j).audit_time, 1561623179);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).restriction_amount", model.packageInfo.itemList.get(i).skuList.get(j).restriction_amount, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).fpostage_amount", model.packageInfo.itemList.get(i).skuList.get(j).fpostage_amount, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).online_time", model.packageInfo.itemList.get(i).skuList.get(j).online_time, 1561623179);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).only_new_user", model.packageInfo.itemList.get(i).skuList.get(j).only_new_user, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).feature", model.packageInfo.itemList.get(i).skuList.get(j).feature, "pin");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).lowest_web_price", model.packageInfo.itemList.get(i).skuList.get(j).lowest_web_price, 10000);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).version_id", model.packageInfo.itemList.get(i).skuList.get(j).version_id);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).offline_before_expired", model.packageInfo.itemList.get(i).skuList.get(j).offline_before_expired, 2592000);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).merchantId", model.packageInfo.itemList.get(i).skuList.get(j).merchantId, 139);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).joinActivityId", model.packageInfo.itemList.get(i).skuList.get(j).joinActivityId, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).canDelivery", model.packageInfo.itemList.get(i).skuList.get(j).canDelivery, true);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).dealAmount", model.packageInfo.itemList.get(i).skuList.get(j).dealAmount, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).dealPrice", model.packageInfo.itemList.get(i).skuList.get(j).dealPrice, "10000");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).totalPrice", model.packageInfo.itemList.get(i).skuList.get(j).totalPrice, 10000);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).left_stock", model.packageInfo.itemList.get(i).skuList.get(j).left_stock);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).max_cart_nums", model.packageInfo.itemList.get(i).skuList.get(j).max_cart_nums);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).amount", model.packageInfo.itemList.get(i).skuList.get(j).amount, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).orderPrice", model.packageInfo.itemList.get(i).skuList.get(j).orderPrice, "10000");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).skuId", model.packageInfo.itemList.get(i).skuList.get(j).skuId, 34573);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).sku_name", model.packageInfo.itemList.get(i).skuList.get(j).sku_name, "最后一遍流程 测试");
                    assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).attrs", model.packageInfo.itemList.get(i).skuList.get(j).attrs);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).attrs.get(0).name", model.packageInfo.itemList.get(i).skuList.get(j).attrs.get(0).name, "规格");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).attrs.get(0).value", model.packageInfo.itemList.get(i).skuList.get(j).attrs.get(0).value, "测试");
                    assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).attrs_desc", model.packageInfo.itemList.get(i).skuList.get(j).attrs_desc);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).productId", model.packageInfo.itemList.get(i).skuList.get(j).productId, 28776);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).skuThumbnail", model.packageInfo.itemList.get(i).skuList.get(j).skuThumbnail);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).sourceType", model.packageInfo.itemList.get(i).skuList.get(j).sourceType, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).double_discount_price", model.packageInfo.itemList.get(i).skuList.get(j).double_discount_price, 0);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).discount_activity.discount_activity_id", model.packageInfo.itemList.get(i).skuList.get(j).discount_activity.discount_activity_id);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).discount_activity.discount_price", model.packageInfo.itemList.get(i).skuList.get(j).discount_activity.discount_price);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).discount_activity.shop_discount", model.packageInfo.itemList.get(i).skuList.get(j).discount_activity.shop_discount);

                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).pic", model.packageInfo.itemList.get(i).skuList.get(j).pic);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).active", model.packageInfo.itemList.get(i).skuList.get(j).active, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).schema", model.packageInfo.itemList.get(i).skuList.get(j).schema, "https://m.haoshiqi.net/v2/detail?id=34573");
                }
                assertNotNull("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price);
                assertNotNull("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips);
                assertNotNull("packageInfo.itemList.get(i).deliveryPrice", model.packageInfo.itemList.get(i).deliveryPrice);
                assertNotNull("packageInfo.itemList.get(i).delivery_fee_way", model.packageInfo.itemList.get(i).delivery_fee_way);
                assertTrue("packageInfo.itemList.get(i).isDeliveryFree", model.packageInfo.itemList.get(i).isDeliveryFree);
                assertNotNull("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount);
                assertNotNull("packageInfo.itemList.get(i).merchantCouponList", model.packageInfo.itemList.get(i).merchantCouponList);
                assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 10000);
                assertEquals("packageInfo.itemList.get(i).merchant_url", model.packageInfo.itemList.get(i).merchant_url, "http://m.beta.haoshiqi.net/v2/merchant?id=139");
            }
            assertNotNull("packageInfo.platformCouponList", model.packageInfo.platformCouponList);
            assertNotNull("packageInfo.platformDiscount", model.packageInfo.platformDiscount);
            assertNotNull("packageInfo.discountTotal", model.packageInfo.discountTotal);
            assertNotNull("packageInfo.savePrice", model.packageInfo.savePrice);

            assertEquals("paymentway.get(0).id", model.paymentway.get(0).id, 1);
            assertEquals("paymentway.get(0).name", model.paymentway.get(0).name, "微信支付");
            assertNotNull("paymentway.get(0).icon", model.paymentway.get(0).icon);
            assertTrue("orderAvailable", model.orderAvailable);

            assertEquals("address.id", model.address.id, 1586);
            assertEquals("address.province", model.address.province, "上海");
            assertEquals("address.city", model.address.city, "上海市");
            assertEquals("address.district", model.address.district, "黄浦区");
            assertEquals("address.contacter", model.address.contacter, "测试");
            assertEquals("address.detail_address", model.address.detail_address, "测试地址");
            assertEquals("address.mobile", model.address.mobile, "138****0000");
            assertNotEmpty("confirmSid", model.confirmSid);


        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {
            assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 10000);
            assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 1);
            assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 10000);
            for (int i = 0; i < model.packageInfo.itemList.size(); i++) {
                assertEquals("packageInfo.itemList.get(i).merchant_id", model.packageInfo.itemList.get(i).merchant_id, 1786);
                assertEquals("packageInfo.itemList.get(i).merchant_name", model.packageInfo.itemList.get(i).merchant_name, "淘食铺");
                assertNotNull("packageInfo.itemList.get(i).icon", model.packageInfo.itemList.get(i).icon);
                assertEquals("packageInfo.itemList.get(i).freeDeliveryPrice", model.packageInfo.itemList.get(i).freeDeliveryPrice, 0);
                assertEquals("packageInfo.itemList.get(i).isFreeDelivery", model.packageInfo.itemList.get(i).isFreeDelivery, 1);
                assertEquals("packageInfo.itemList.get(i).isFreeBaseWeight", model.packageInfo.itemList.get(i).isFreeBaseWeight, 0);
                assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 10000);
                assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 1);
                assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 10000);
                assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 10000);
                assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).totalWeight, 0);
                assertEquals("packageInfo.itemList.get(i).totalWeightSum", model.packageInfo.itemList.get(i).totalWeightSum, 0);
                for (int j = 0; j < model.packageInfo.itemList.get(i).skuList.size(); j++) {
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).id", model.packageInfo.itemList.get(i).skuList.get(j).id, 126072);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).merchant_id", model.packageInfo.itemList.get(i).skuList.get(j).merchant_id, 1786);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).product_id", model.packageInfo.itemList.get(i).skuList.get(j).product_id, 93022);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).name", model.packageInfo.itemList.get(i).skuList.get(j).name, "购物车接口自动化勿动 购物车接口自动化测试勿动");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).weight", model.packageInfo.itemList.get(i).skuList.get(j).weight, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).price", model.packageInfo.itemList.get(i).skuList.get(j).price, 10000);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).thumbnail", model.packageInfo.itemList.get(i).skuList.get(j).thumbnail);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).market_price", model.packageInfo.itemList.get(i).skuList.get(j).market_price, 10000);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).lowest_price", model.packageInfo.itemList.get(i).skuList.get(j).lowest_price, 10000);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).seller_time", model.packageInfo.itemList.get(i).skuList.get(j).seller_time, 1568297381);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).expired_date", model.packageInfo.itemList.get(i).skuList.get(j).expired_date, "2426947200");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).manufactured_date", model.packageInfo.itemList.get(i).skuList.get(j).manufactured_date, "2019-07-13");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).enabled", model.packageInfo.itemList.get(i).skuList.get(j).enabled, 1);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).liked_cnt", model.packageInfo.itemList.get(i).skuList.get(j).liked_cnt);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).ugc_cnt", model.packageInfo.itemList.get(i).skuList.get(j).ugc_cnt);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).selled_cnt", model.packageInfo.itemList.get(i).skuList.get(j).selled_cnt);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).merchant_item_code", model.packageInfo.itemList.get(i).skuList.get(j).merchant_item_code);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).actived", model.packageInfo.itemList.get(i).skuList.get(j).actived, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).delete_flag", model.packageInfo.itemList.get(i).skuList.get(j).delete_flag, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).created_at", model.packageInfo.itemList.get(i).skuList.get(j).created_at, 1568297322);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).updated_at", model.packageInfo.itemList.get(i).skuList.get(j).updated_at);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).audit_status", model.packageInfo.itemList.get(i).skuList.get(j).audit_status, 2);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).audit_time", model.packageInfo.itemList.get(i).skuList.get(j).audit_time, 1568297381);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).restriction_amount", model.packageInfo.itemList.get(i).skuList.get(j).restriction_amount, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).fpostage_amount", model.packageInfo.itemList.get(i).skuList.get(j).fpostage_amount, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).online_time", model.packageInfo.itemList.get(i).skuList.get(j).online_time, 1568297381);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).only_new_user", model.packageInfo.itemList.get(i).skuList.get(j).only_new_user, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).feature", model.packageInfo.itemList.get(i).skuList.get(j).feature, "pin");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).lowest_web_price", model.packageInfo.itemList.get(i).skuList.get(j).lowest_web_price, 10000);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).version_id", model.packageInfo.itemList.get(i).skuList.get(j).version_id);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).offline_before_expired", model.packageInfo.itemList.get(i).skuList.get(j).offline_before_expired, 2592000);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).merchantId", model.packageInfo.itemList.get(i).skuList.get(j).merchantId, 1786);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).joinActivityId", model.packageInfo.itemList.get(i).skuList.get(j).joinActivityId, 0);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).canDelivery", model.packageInfo.itemList.get(i).skuList.get(j).canDelivery, true);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).dealAmount", model.packageInfo.itemList.get(i).skuList.get(j).dealAmount, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).dealPrice", model.packageInfo.itemList.get(i).skuList.get(j).dealPrice, "10000");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).totalPrice", model.packageInfo.itemList.get(i).skuList.get(j).totalPrice, 10000);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).left_stock", model.packageInfo.itemList.get(i).skuList.get(j).left_stock);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).max_cart_nums", model.packageInfo.itemList.get(i).skuList.get(j).max_cart_nums);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).amount", model.packageInfo.itemList.get(i).skuList.get(j).amount, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).orderPrice", model.packageInfo.itemList.get(i).skuList.get(j).orderPrice, "10000");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).skuId", model.packageInfo.itemList.get(i).skuList.get(j).skuId, 126072);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).sku_name", model.packageInfo.itemList.get(i).skuList.get(j).sku_name, "购物车接口自动化勿动 购物车接口自动化测试勿动");
                    assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).attrs", model.packageInfo.itemList.get(i).skuList.get(j).attrs);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).attrs.get(0).name", model.packageInfo.itemList.get(i).skuList.get(j).attrs.get(0).name, "规格");
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).attrs.get(0).value", model.packageInfo.itemList.get(i).skuList.get(j).attrs.get(0).value, "购物车接口自动化测试勿动");
                    assertNotEmpty("packageInfo.itemList.get(i).skuList.get(j).attrs_desc", model.packageInfo.itemList.get(i).skuList.get(j).attrs_desc);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).productId", model.packageInfo.itemList.get(i).skuList.get(j).productId, 93022);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).skuThumbnail", model.packageInfo.itemList.get(i).skuList.get(j).skuThumbnail);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).sourceType", model.packageInfo.itemList.get(i).skuList.get(j).sourceType, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).double_discount_price", model.packageInfo.itemList.get(i).skuList.get(j).double_discount_price, 0);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).discount_activity.discount_activity_id", model.packageInfo.itemList.get(i).skuList.get(j).discount_activity.discount_activity_id);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).discount_activity.discount_price", model.packageInfo.itemList.get(i).skuList.get(j).discount_activity.discount_price);
                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).discount_activity.shop_discount", model.packageInfo.itemList.get(i).skuList.get(j).discount_activity.shop_discount);

                    assertNotNull("packageInfo.itemList.get(i).skuList.get(j).pic", model.packageInfo.itemList.get(i).skuList.get(j).pic);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).active", model.packageInfo.itemList.get(i).skuList.get(j).active, 1);
                    assertEquals("packageInfo.itemList.get(i).skuList.get(j).schema", model.packageInfo.itemList.get(i).skuList.get(j).schema, "https://m.haoshiqi.net/v2/detail?id=126072");
                }
                assertNotNull("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price);
                assertNotNull("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips);
                assertNotNull("packageInfo.itemList.get(i).deliveryPrice", model.packageInfo.itemList.get(i).deliveryPrice);
                assertNotNull("packageInfo.itemList.get(i).delivery_fee_way", model.packageInfo.itemList.get(i).delivery_fee_way);
                assertTrue("packageInfo.itemList.get(i).isDeliveryFree", model.packageInfo.itemList.get(i).isDeliveryFree);
                assertNotNull("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount);
                assertNotNull("packageInfo.itemList.get(i).merchantCouponList", model.packageInfo.itemList.get(i).merchantCouponList);
                assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 10000);
                assertEquals("packageInfo.itemList.get(i).merchant_url", model.packageInfo.itemList.get(i).merchant_url, "https://m.haoshiqi.net/v2/merchant?id=1786");
            }
            assertNotNull("packageInfo.platformCouponList", model.packageInfo.platformCouponList);
            assertNotNull("packageInfo.platformDiscount", model.packageInfo.platformDiscount);
            assertNotNull("packageInfo.discountTotal", model.packageInfo.discountTotal);
            assertNotNull("packageInfo.savePrice", model.packageInfo.savePrice);

            assertEquals("paymentway.get(0).id", model.paymentway.get(0).id, 1);
            assertEquals("paymentway.get(0).name", model.paymentway.get(0).name, "微信支付");
            assertNotNull("paymentway.get(0).icon", model.paymentway.get(0).icon);
            assertTrue("orderAvailable", model.orderAvailable);

            assertEquals("address.id", model.address.id, 24113077);
            assertEquals("address.province", model.address.province, "上海");
            assertEquals("address.city", model.address.city, "上海市");
            assertEquals("address.district", model.address.district, "宝山区");
            assertEquals("address.contacter", model.address.contacter, "测试");
            assertEquals("address.detail_address", model.address.detail_address, "测试地址");
            assertEquals("address.mobile", model.address.mobile, "138****0000");
            assertNotEmpty("confirmSid", model.confirmSid);


        }
    }

    private void merchantAssert() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 15554);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 2);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 14854);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {
            assertEquals("packageInfo.itemList.get(i).freeDeliveryPrice", model.packageInfo.itemList.get(i).freeDeliveryPrice, 0);
            assertEquals("packageInfo.itemList.get(i).isFreeDelivery", model.packageInfo.itemList.get(i).isFreeDelivery, 1);
            assertEquals("packageInfo.itemList.get(i).isFreeBaseWeight", model.packageInfo.itemList.get(i).isFreeBaseWeight, 0);

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 15554);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 2);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 19998);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 15154);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 0);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "");

            assertEquals("packageInfo.itemList.get(i).deliveryPrice", model.packageInfo.itemList.get(i).deliveryPrice, 0);
            assertEquals("packageInfo.itemList.get(i).delivery_fee_way", model.packageInfo.itemList.get(i).delivery_fee_way, 1);
            assertEquals("packageInfo.itemList.get(i).isDeliveryFree", model.packageInfo.itemList.get(i).isDeliveryFree, true);

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 15154);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 300);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 700);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 5144);

    }

    private void assertNoLose2() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 2222);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 1);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 1522);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {
            assertEquals("packageInfo.itemList.get(i).freeDeliveryPrice", model.packageInfo.itemList.get(i).freeDeliveryPrice, 0);
            assertEquals("packageInfo.itemList.get(i).isFreeDelivery", model.packageInfo.itemList.get(i).isFreeDelivery, 1);
            assertEquals("packageInfo.itemList.get(i).isFreeBaseWeight", model.packageInfo.itemList.get(i).isFreeBaseWeight, 0);

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 2222);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 1);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 3333);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 1822);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 0);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "第2件减11.1元");

            assertEquals("packageInfo.itemList.get(i).deliveryPrice", model.packageInfo.itemList.get(i).deliveryPrice, 0);
            assertEquals("packageInfo.itemList.get(i).delivery_fee_way", model.packageInfo.itemList.get(i).delivery_fee_way, 1);
            assertEquals("packageInfo.itemList.get(i).isDeliveryFree", model.packageInfo.itemList.get(i).isDeliveryFree, true);

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 1822);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 300);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 700);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 1811);

    }

    private void assertLose2() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 4444);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 2);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 2634);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {
            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 4444);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 2);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 6666);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 2934);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 1110);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 11.10");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 2934);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 300);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 1810);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 4032);

    }

    private void assertLose23() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 6699);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 3);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 5699);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 6699);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 3);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 9999);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 5699);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 600);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 6.00");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 5699);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 1000);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 4300);

    }

    private void assertLose24() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 8976);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 4);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 7344);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 8976);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 4);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 13332);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 7344);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 1232);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 12.32");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 7344);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 1632);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 5988);

    }

    private void assertLose235() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11275);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 10275);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11275);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 10275);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 600);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 6.00");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 10275);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 1000);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 6390);

    }

    private void assertDiscount3() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 6666);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 3);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 4067);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 6666);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 3);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 9999);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 4067);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 2199);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 21.99");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 4067);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 2599);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 5932);

    }

    private void assertDiscount34() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 8932);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 4);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 6299);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 8932);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 4);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 13332);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 6299);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 2233);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 22.33");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 6299);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 2633);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 7033);

    }

    private void assertDiscount35() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11220);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 8276);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11220);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 8576);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 2244);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 22.44");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 8576);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 300);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 2944);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 8389);

    }

    private void assertDiscount245() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11275);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 9522);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11275);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 9522);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 1353);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 13.53");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 9522);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 1753);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 7143);

    }

    private void assertDiscount2345() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11330);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 6172);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11330);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 6172);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 4758);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 47.58");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 6172);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 5158);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 10493);

    }

    private void assertPay5() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11110);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 9598);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11110);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 9598);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 1112);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 11.12");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 9598);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 1512);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 7067);

    }

    private void assertPay45() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11165);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 6800);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11165);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 6800);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 3965);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 39.65");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 6800);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 4365);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 9865);

    }

    private void assertPay25() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11220);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 7465);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11220);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 7465);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 3355);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 33.55");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 7465);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 3755);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 9200);

    }

    private void assertPay345() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11275);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 6054);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11275);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 6054);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 4821);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 48.21");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 6054);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 0);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 5221);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 10611);

    }

    private void assertPay2345() {
        assertEquals("packageInfo.totalPrice", model.packageInfo.totalPrice, 11330);
        assertEquals("packageInfo.totalAmount", model.packageInfo.totalAmount, 5);
        assertEquals("packageInfo.needPayPrice", model.packageInfo.needPayPrice, 4021);

        for (int i = 0; i < model.packageInfo.itemList.size(); i++) {

            assertEquals("packageInfo.itemList.get(i).totalPrice", model.packageInfo.itemList.get(i).totalPrice, 11330);
            assertEquals("packageInfo.itemList.get(i).totalAmount", model.packageInfo.itemList.get(i).totalAmount, 5);
            assertEquals("packageInfo.itemList.get(i).marketPrice", model.packageInfo.itemList.get(i).marketPrice, 16665);
            assertEquals("packageInfo.itemList.get(i).needPayPrice", model.packageInfo.itemList.get(i).needPayPrice, 4321);
            assertEquals("packageInfo.itemList.get(i).total_double_discount_price", model.packageInfo.itemList.get(i).total_double_discount_price, 6609);
            assertEquals("packageInfo.itemList.get(i).lately_double_tips", model.packageInfo.itemList.get(i).lately_double_tips, "- ¥ 66.09");

            assertEquals("packageInfo.itemList.get(i).merchantDiscount", model.packageInfo.itemList.get(i).merchantDiscount, 400);
            assertEquals("packageInfo.itemList.get(i).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(i).needPayWithoutPlatformDiscount, 4321);

        }

        assertEquals("packageInfo.platformDiscount", model.packageInfo.platformDiscount, 300);
        assertEquals("packageInfo.discountTotal", model.packageInfo.discountTotal, 7309);
        assertEquals("packageInfo.savePrice", model.packageInfo.savePrice, 12644);

    }


}