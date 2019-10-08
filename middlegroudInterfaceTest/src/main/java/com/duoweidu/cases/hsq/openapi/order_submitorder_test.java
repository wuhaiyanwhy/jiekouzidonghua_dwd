package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderSubmitorderData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_submitorder_test extends HsqInterfaceTest {

    private OrderSubmitorderData model;

    private void submitorderConfig(List<NameValuePair> list, String orderinitResult) {
        setUrl("order.submitorder.uri");
        try {
            JSONObject jsonResult = new JSONObject(orderinitResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            JSONObject address = (JSONObject) data.get("address");
            String confirmSid = (String) data.get("confirmSid");
            String id = address.get("id").toString();

            list.add(new BasicNameValuePair("confirmOrderSerialId", confirmSid));
            list.add(new BasicNameValuePair("addressId", id));
            list.add(new BasicNameValuePair("invoice", "{\"type\":1}"));
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
        process(list,true,false);
        model = sparseJson(OrderSubmitorderData.class);
        generalDetailAssert();

    }

    @Test(dependsOnGroups = "orderinitPutong",description = "提交订单（普通）",groups = "submitorderPutong")
    public void order_submitorder_putongTrue() {
        List<NameValuePair> list = new LinkedList<>();
        submitorderConfig(list, HsqOpenapiConfig.orderinitResult);
        //submitorder普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.submitorderPutongResult = result;
        //判断结算价
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 1804);
        }
    }

    @Test(dependsOnGroups = "orderinitPintuan",description = "提交订单（拼团）",groups = "submitorderPintuan")
    public void order_submitorder_pintuanTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType","3"));
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitPintuanResult);
        //submitorder普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.submitorderPintuanResult = result;
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 95);
        }
    }


    @Test(dependsOnGroups = "orderinitDandugou",description = "提交订单（单独购）(用券)",groups = "submitorderDandugou")
    public void order_submitorder_dandugouTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType", "2"));
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("couponId", String.valueOf(HsqOpenapiConfig.couponId)));
            list.add(new BasicNameValuePair("couponCode", HsqOpenapiConfig.couponCode));
        }
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitDandugouResult);
        //submitorder普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.submitorderDandugouResult = result;
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 1044);
        }

    }

    @Test(dependsOnGroups = "orderinitChouPintuan",description = "提交订单（抽奖团拼团）",groups = "submitorderChouPintuan")
    public void order_submitorder_chouPintuanTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType", "4"));
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitChouPintuanResult);
        //submitorder普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.submitorderChouPintuanResult = result;
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 284);
        }
    }

    @Test(dependsOnGroups = "orderinitChouDandugou",description = "提交订单（抽奖团拼团）",groups = "submitorderChouDandugou")
    public void order_submitorder_chouDandugouTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType", "5"));
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitChouDandugouResult);
        //submitorder普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.submitorderChouDandugouResult = result;
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 9594);
        }
    }

    @Test(dependsOnGroups = "orderinitActivitePintuan",description = "提交订单（拼团）(活动报名+商家优惠券)",groups = "submitorderActivitePintuan")
    public void order_submitorder_activitePintuanTrue() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActivitiePintuanResult);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 1);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitNoLosePintuan2",description = "提交订单（拼团）（多件优惠减钱第二件，未达到优惠条件+商家优惠券）",groups = "submitorderNoLosePintuan2")
    public void order_submitorder_noLosePintuanTrue2() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitNoLosePintuanResult2);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 1055);
        }else {
            System.out.println("此环境无此cases");
        }
    }


    @Test(dependsOnGroups = "orderinitLosePintuan2",description = "提交订单（拼团）(多件优惠减钱第二件)",groups = "submitorderLosePintuan2")
    public void order_submitorder_losePintuanTrue2() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType", "3"));
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitLosePintuanResult2);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 1056);
        }
    }

    @Test(dependsOnGroups = "orderinitLosePintuan23",description = "提交订单（拼团）(多件优惠减钱 23)",groups = "submitorderLosePintuan23")
    public void order_submitorder_losePintuanTrue23() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitLosePintuanResult23);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 2628);
        }else {
            System.out.println("此环境无此cases");
        }
    }

    @Test(dependsOnGroups = "orderinitLosePintuan24",description = "提交订单（拼团）(多件优惠减钱 24)",groups = "submitorderLosePintuan24")
    public void order_submitorder_losePintuanTrue24() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitLosePintuanResult24);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 3135);
        }else {
            System.out.println("此环境无此cases");
        }


    }

    @Test(dependsOnGroups = "orderinitLosePintuan235",description = "提交订单（拼团）(多件优惠减钱 235)",groups = "submitorderLosePintuan235")
    public void order_submitorder_losePintuanTrue235() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitLosePintuanResult235);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 4864);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitLoseDan2345",description = "提交订单（拼团）(多件优惠减钱 2345)",groups = "submitorderLoseDan2345")
    public void order_submitorder_loseDandugouTrue2345() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "2"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitLoseDandugouResult2345);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 7907);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitDiscountPintuan3",description = "提交订单（拼团）(多件优惠打折第三件)",groups = "submitorderDiscountPintuan3")
    public void order_submitorder_discountPintuan3() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitDiscountPintuan3);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 2122);
        }else {
            System.out.println("此环境无此cases");
        }
    }

    @Test(dependsOnGroups = "orderinitDiscountPintuan34",description = "提交订单（拼团）(多件优惠打折 34)",groups = "submitorderDiscountPintuan34")
    public void order_submitorder_discountPintuan34() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitDiscountPintuan34);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 3198);
        }else {
            System.out.println("此环境无此cases");
        }


    }

    @Test(dependsOnGroups = "orderinitDiscountPintuan35",description = "提交订单（拼团）(多件优惠打折 34)",groups = "submitorderDiscountPintuan35")
    public void order_submitorder_discountPintuan35() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType", "3"));
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitDiscountPintuan35);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 4305);
        }

    }

    @Test(dependsOnGroups = "orderinitDiscountDan245",description = "提交订单（拼团）(多件优惠打折 245)",groups = "submitorderDiscountDandugou245")
    public void order_submitorder_discountDandugou245() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "2"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitDiscountDandugou245);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 9426);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitDiscountPintuan2345",description = "提交订单（拼团）(多件优惠打折 2345)",groups = "submitorderDiscountPintuan2345")
    public void order_submitorder_discountPintuan2345() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitDiscountPintuan2345);
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 3183);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitPayPintuan5",description = "提交订单（拼团）(多件优惠付钱 5)",groups = "submitorderPayPintuan5")
    public void order_submitorder_payPintuan5() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitPayPintuan5);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 5276);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitPayDandugou45",description = "提交订单（拼团）(多件优惠付钱 45)",groups = "submitorderPayDandugou45")
    public void order_submitorder_payDandugou45() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "2"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitPayDandugou45);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 6840);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitPayPintuan25",description = "提交订单（拼团）(多件优惠付钱 25)",groups = "submitorderPayPintuan25")
    public void order_submitorder_payPintua25() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitPayPintuan25);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 4305);
        }else {
            System.out.println("此环境无此cases");
        }

    }


    @Test(dependsOnGroups = "orderinitPayPintuan235",description = "提交订单（拼团）(多件优惠付钱 235)",groups = "submitorderPayPintuan235")
    public void order_submitorder_payPintua235() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitPayPintuan235);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 4020);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitPayPintuan2345",description = "提交订单（拼团）(多件优惠付钱 2345)",groups = "submitorderPayPintuan2345")
    public void order_submitorder_payPintua2345() {

        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType", "3"));
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitPayPintuan2345);

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 3430);
        }

    }

    @Test(dependsOnGroups = "orderinitNoPayPintuan2345",description = "提交订单（拼团）(多件优惠付钱 2345,未达到第五件)",groups = "submitorderNoPayPintuan2345")
    public void order_submitorder_noPayPintua2345() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitNoPayPintuan2345);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 2955);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitActiviteLosePintuan2",description = "提交订单（拼团）(营销活动+多件优惠减钱，减钱金额>单个订单金额)",groups = "submitorderActiviteLosePintuan2")
    public void order_submitorder_activiteLosePintuan2() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteLosePintuan2);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 285);
        }else {
            System.out.println("此环境无此cases");
        }


    }

    @Test(dependsOnGroups = "orderinitActiviteLosePintuan3",description = "提交订单（拼团）(营销活动+多件优惠减钱，减钱金额=单个订单金额)",groups = "submitorderActiviteLosePintuan3")
    public void order_submitorder_activiteLosePintuan3() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteLosePintuan3);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 285);
        }else {
            System.out.println("此环境无此cases");
        }
    }

    @Test(dependsOnGroups = "orderinitActiviteLosePintuan4",description = "提交订单（拼团）(营销活动+多件优惠减钱，减钱金额<单个订单金额)",groups = "submitorderActiviteLosePintuan4")
    public void order_submitorder_activiteLosePintuan4() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteLosePintuan4);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 475);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitActiviteLosePintuan5",description = "提交订单（拼团）(营销活动+多件优惠减钱+优惠券)",groups = "submitorderActiviteLosePintuan5")
    public void order_submitorder_activiteLosePintuan5() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteLosePintuan5);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 760);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitActiviteLoseDandugou2",description = "提交订单（拼团）(营销活动+多件优惠减钱单独购)",groups = "submitorderActiviteLoseDandugou2")
    public void order_submitorder_activiteLoseDandugou2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "2"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteLoseDandugou2);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 16032);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitActiviteDiscountPintuan2",description = "提交订单（拼团）(营销活动+多件优惠打折，打折第二件9.9折)",groups = "submitorderActiviteDiscountPintuan2")
    public void order_submitorder_ActiviteDiscountPintuan2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteDiscountPintuan2);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 567);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitActiviteDiscountDandugou4",description = "提交订单（拼团）(营销活动+多件优惠打折，打折第四件5折)",groups = "submitorderActiviteDiscountDandugou4")
    public void order_submitorder_ActiviteDiscountDandugou4() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "2"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteDiscountDandugouResult4);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 29469);
        }else {
            System.out.println("此环境无此cases");
        }
    }

    @Test(dependsOnGroups = "orderinitActiviteDiscountPintuan5",description = "提交订单（拼团）(营销活动+多件优惠打折，打折第五件1折)",groups = "submitorderActiviteDiscountPintuan5")
    public void order_submitorder_ActiviteDiscountPintuan5() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteDiscountPintuan5);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 1308);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitActivitePayPintuan2",description = "提交订单（拼团）(营销活动+多件优惠付钱，付钱金额<订单金额)",groups = "submitorderActivitePayPintuan2")
    public void order_submitorder_activitePayPintuan2() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActivitePayResult2);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 475);
        }else {
            System.out.println("此环境无此cases");
        }
    }

    @Test(dependsOnGroups = "orderinitActivitePayPintuan3",description = "提交订单（拼团）(营销活动+多件优惠付钱，付钱金额=订单金额)",groups = "submitorderActivitePayPintuan3")
    public void order_submitorder_activitePayPintuan3() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActivitePayResult3);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 760);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitActivitePayPintuan5",description = "提交订单（拼团）(活动报名+多件优惠付钱)",groups = "submitorderActivitePayPintuan5")
    public void order_submitorder_activitePayPintuan5() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActivitePayResult5);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 1330);
        }else {
            System.out.println("此环境无此cases");
        }

    }

    @Test(dependsOnGroups = "orderinitXinyonggou", description = "提交订单（信用购）",groups = "submitorderXinyonggou")
    public void order_submitorder_xinyong() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "11"));
            list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("token")));
            submitorderConfig(list, HsqOpenapiConfig.orderInitResult);

            assertEquals("settlementPrice", SqlDetail.getInstance().getSettlementPrice(getOrderId()), 10449);
        }

    }

    private void generalDetailAssert() {
        detailAssertTest(1, "model.orderIds", model.orderIds.size());
        detailAssertTest(true, "model.needPay", model.needPay);
    }

    /**
     * 获取订单id
     * @return
     */
    private String getOrderId() {
        return model.orderIds.get(0).toString();
    }


}
