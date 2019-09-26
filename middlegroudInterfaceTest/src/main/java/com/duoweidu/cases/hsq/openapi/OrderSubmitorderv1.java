package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderSubmitorderv1Data;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderSubmitorderv1 extends HsqInterfaceTest {

    private OrderSubmitorderv1Data model;

    private void getRequest(String confirmOrderSerialId) {
        setUrl("order.submitorder_v1.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("Content-Type",SqlDetail.getInstance().getParamValue(0,"Content-Type")));
        list.add(new BasicNameValuePair("confirmOrderSerialId", confirmOrderSerialId ));
        list.add(new BasicNameValuePair("addressId", SqlDetail.getInstance().getParamValue("goaddressId")));
        process(list,true,false) ;
        model = sparseJson(OrderSubmitorderv1Data.class);
        detailassert();
    }

    @Test(dependsOnGroups = "oderinit",description = "提交普通订单" ,groups = "submitOrder")
    public void orderSubmitorderv1(){
        getRequest(HsqOpenapiConfig.goconfirmSid);
        HsqOpenapiConfig.orderIds= model.orderIds.get(0);
    }

    @Test(dependsOnGroups = "oderinitMerchant",description = "提交普通订单（只有商家优惠，2件）" ,groups = "submitOrderMerchant")
    public void orderSubmitorderv1Merchant(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.merchantConfirmSid);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitNoLose2",description = "多件优惠减钱第二件，未达到优惠条件+商家券+平台券" ,groups = "submitOrderNoLose2")
    public void orderSubmitorderv1NoLose2(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidNoLose2);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitLose2",description = "多件优惠减钱第二件，达到优惠条件+商家券+平台券" ,groups = "submitOrderLose2")
    public void orderSubmitorderv1Lose2(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidLose2);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitLose23",description = "多件优惠减钱23，商家券" ,groups = "submitOrderLose23")
    public void orderSubmitorderv1Lose23(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidLose23);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitLose24",description = "多件优惠减钱23，商家券" ,groups = "submitOrderLose24")
    public void orderSubmitorderv1Lose24(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidLose24);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitLose235",description = "多件优惠减钱235，商家券" ,groups = "submitOrderLose235")
    public void orderSubmitorderv1Lose235(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidLose235);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitDiscount3",description = "多件优惠打折3，商家券" ,groups = "submitOrderDiscount3")
    public void orderSubmitorderv1Discount3(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidDiscount3);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitDiscount34",description = "多件优惠打折34，商家券" ,groups = "submitOrderDiscount34")
    public void orderSubmitorderv1Discount34(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidDiscount34);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitDiscount35",description = "多件优惠打折35，商家券" ,groups = "submitOrderDiscount35")
    public void orderSubmitorderv1Discount35(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidDiscount35);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitDiscount245",description = "多件优惠打折245，商家券" ,groups = "submitOrderDiscount245")
    public void orderSubmitorderv1Discount245(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidDiscount245);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitDiscount2345",description = "多件优惠打折34，商家券" ,groups = "submitOrderDiscount2345")
    public void orderSubmitorderv1Discount2345(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidDiscount2345);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitPay5",description = "多件优惠付钱5，商家券" ,groups = "submitOrderPay5")
    public void orderSubmitorderv1Pay5(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidPay5);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitPay45",description = "多件优惠付钱45，商家券" ,groups = "submitOrderPay45")
    public void orderSubmitorderv1Pay45(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidPay45);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitPay25",description = "多件优惠付钱25，商家券" ,groups = "submitOrderPay25")
    public void orderSubmitorderv1Pay25(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidPay25);
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "oderinitPay345",description = "多件优惠付钱345，商家券" ,groups = "submitOrderPay345")
    public void orderSubmitorderv1Pay345(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidPay345);
        }else {
            System.out.println("此环境无此case");
        }
    }


    @Test(dependsOnGroups = "oderinitPay2345",description = "多件优惠付钱2345，商家券" ,groups = "submitOrderPay2345")
    public void orderSubmitorderv1Pay2345(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            getRequest(HsqOpenapiConfig.confirmSidPay2345);
        }else {
            System.out.println("此环境无此case");
        }
    }

    private void detailassert() {
        assertNotEmpty("orderIds", model.orderIds);
        assertTrue("needPay", model.needPay);
    }
}
