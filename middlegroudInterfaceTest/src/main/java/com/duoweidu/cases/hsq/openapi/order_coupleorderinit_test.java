package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderCoupleorderinitData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_coupleorderinit_test extends HsqInterfaceTest {

    private OrderCoupleorderinitData model;

    private void interfaces(List<NameValuePair> list) {
        setUrl("order.coupleorderinit.uri");
        process(list,true,false);
        model = sparseJson(OrderCoupleorderinitData.class);
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）",groups = "orderinitPintuan")
    public void order_coupleorderinit_pintuanTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue("pinActivitiesId")));
        list.add(new BasicNameValuePair("amount","1"));
        list.add(new BasicNameValuePair("orderType","3"));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("skuId")));
        list.add(new BasicNameValuePair("conformNewUser", "1"));

        interfaces(list);
        //coupleorderinit拼团接口的返回数据确定默认值
        HsqOpenapiConfig.coupleorderinitPintuanResult = result;
        pinDetailAssert();
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（单独购）",groups = "orderinitDandugou")
    public void order_coupleorderinit_dandugouTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue("pinActivitiesId")));
        list.add(new BasicNameValuePair("amount","1"));
        list.add(new BasicNameValuePair("orderType","2"));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("skuId")));
        list.add(new BasicNameValuePair("conformNewUser", "1"));

        interfaces(list);
        //coupleorderinit单独购接口的返回数据确定默认值
        HsqOpenapiConfig.coupleorderinitDandugouResult = result;
        ddgDetailAssert();
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（抽奖团拼团）",groups = "orderinitPintuan")
    public void order_coupleorderinit_chouPintuanTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue("chouActivitiesId")));
        list.add(new BasicNameValuePair("amount","1"));
        list.add(new BasicNameValuePair("orderType","4"));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("chouSkuId")));
        list.add(new BasicNameValuePair("conformNewUser", "1"));

        interfaces(list);
        chouPinDetailAssert();
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（抽奖团单独购）",groups = "orderinitDandugou")
    public void order_coupleorderinit_chouDandugouTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue("chouActivitiesId")));
        list.add(new BasicNameValuePair("amount","1"));
        list.add(new BasicNameValuePair("orderType","5"));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("chouSkuId")));
        list.add(new BasicNameValuePair("conformNewUser", "1"));

        interfaces(list);
        chouDdgDetailAssert();
    }


    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（活动报名不用券）", groups = "orderinitActivitePintuan")
    public void order_coupleorderinit_activitiePintuanTrue() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitiePinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "1"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            //coupleorderinit拼团接口的返回数据确定默认值
            HsqOpenapiConfig.coupleorderinitActivitiePintuanResult = result;
            activitiePinDetailAssert();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠减钱第二件，未达到优惠条件）", groups = "orderinitLosePintuan2")
    public void order_coupleorderinit_nolosePintuan2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "losePinActivitiesId2")));
            list.add(new BasicNameValuePair("amount", "1"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "loseSkuId2")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            nolosePinDetailAssert();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠减钱第二件）", groups = "orderinitLosePintuan2")
    public void order_coupleorderinit_losePintuan2() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue("losePinActivitiesId2")));
        list.add(new BasicNameValuePair("amount", "2"));
        list.add(new BasicNameValuePair("orderType", "3"));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("loseSkuId2")));
        list.add(new BasicNameValuePair("conformNewUser", "1"));

        interfaces(list);
        //coupleorderinit拼团接口的返回数据确定默认值
        HsqOpenapiConfig.coupleorderinitLosePintuanResult2 = result;
        losePinDetailAssert2();
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠减钱 23）", groups = "orderinitLosePintuan23")
    public void order_coupleorderinit_losePintuan23() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "losePinActivitiesId23")));
            list.add(new BasicNameValuePair("amount", "3"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "loseSkuId23")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            losePinDetailAssert23();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠减钱 24）", groups = "orderinitLosePintuan24")
    public void order_coupleorderinit_losePintuan24() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "losePinActivitiesId24")));
            list.add(new BasicNameValuePair("amount", "4"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "loseSkuId24")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            losePinDetailAssert24();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠减钱 235）", groups = "orderinitLosePintuan235")
    public void order_coupleorderinit_losePintuan235() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "losePinActivitiesId235")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "loseSkuId235")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            losePinDetailAssert235();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（单独够）（多件优惠减钱 2345）", groups = "orderinitLoseDan2345")
    public void order_coupleorderinit_loseDandugou2345() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "losePinActivitiesId2345")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "2"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "loseSkuId2345")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            loseDanDetailAssert2345();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠打折第三件）", groups = "orderinitDiscountPintuan3")
    public void order_coupleorderinit_discountPintuan3() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "discountPinActivitiesId3")));
            list.add(new BasicNameValuePair("amount", "3"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "discountSkuId3")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            discountPinDetailAssert3();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠打折 三四件）", groups = "orderinitDiscountPintuan34")
    public void order_coupleorderinit_discountPintuan34() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "discountPinActivitiesId34")));
            list.add(new BasicNameValuePair("amount", "4"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "discountSkuId34")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            discountPinDetailAssert34();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠打折 三五件）", groups = "orderinitDiscountPintuan35")
    public void order_coupleorderinit_discountPintuan35() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue("discountPinActivitiesId35")));
        list.add(new BasicNameValuePair("amount", "5"));
        list.add(new BasicNameValuePair("orderType", "3"));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("discountSkuId35")));
        list.add(new BasicNameValuePair("conformNewUser", "1"));

        interfaces(list);
        discountPinDetailAssert35();
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠打折 二四五件）", groups = "orderinitDiscountDan35")
    public void order_coupleorderinit_discountDandugou245() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "discountPinActivitiesId245")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "2"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "discountSkuId245")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            discountDanDetailAssert245();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠打折 二三四五件）", groups = "orderinitDiscountPintuan2345")
    public void order_coupleorderinit_discountPintuan2345() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "discountPinActivitiesId2345")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "discountSkuId2345")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            discountPinDetailAssert2345();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠付钱第五件）", groups = "orderinitPayPintuan5")
    public void order_coupleorderinit_payPintuan5() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "payPinActivitiesId5")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "paySkuId5")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            payPinDetailAssert5();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠付钱 四五件）", groups = "orderinitPayDandugou45")
    public void order_coupleorderinit_payDandugou45() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "payPinActivitiesId45")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "2"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "paySkuId45")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            payDanDetailAssert45();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠付钱 二五件）", groups = "orderinitPayPintuan25")
    public void order_coupleorderinit_payPintuan25() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "payPinActivitiesId25")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "paySkuId25")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            payPinDetailAssert25();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠付钱 二三五件）", groups = "orderinitPayPintuan235")
    public void order_coupleorderinit_payPintuan235() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "payPinActivitiesId235")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "paySkuId235")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            payPinDetailAssert235();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠付钱 二三四五件）", groups = "orderinitPayPintuan2345")
    public void order_coupleorderinit_payPintuan2345() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue("payPinActivitiesId2345")));
        list.add(new BasicNameValuePair("amount", "5"));
        list.add(new BasicNameValuePair("orderType", "3"));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("paySkuId2345")));
        list.add(new BasicNameValuePair("conformNewUser", "1"));

        interfaces(list);
        payPinDetailAssert2345();
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（多件优惠付钱 二三四五件,未达到第五件）", groups = "orderinitNoPayPintuan2345")
    public void order_coupleorderinit_noPayPintuan2345() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "payPinActivitiesId2345")));
            list.add(new BasicNameValuePair("amount", "4"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "paySkuId2345")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            noPayPinDetailAssert2345();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠减钱，减钱金额>单个订单金额）", groups = "orderinitActiviteLosePintuan2")
    public void order_coupleorderinit_activiteLosePintuan2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitieLosePinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "2"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieLoseSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activiteLosePinDetailAssert2();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠减钱，减钱金额=单个订单金额）", groups = "orderinitActiviteLosePintuan3")
    public void order_coupleorderinit_activiteLosePintuan3() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitieLosePinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "3"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieLoseSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activiteLosePinDetailAssert3();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠减钱，减钱金额<单个订单金额）", groups = "orderinitActiviteLosePintuan4")
    public void order_coupleorderinit_activiteLosePintuan4() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitieLosePinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "4"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieLoseSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activiteLosePinDetailAssert4();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠减钱+优惠券）", groups = "orderinitActiviteLosePintuan4")
    public void order_coupleorderinit_activiteLosePintuan5() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitieLosePinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieLoseSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activiteLosePinDetailAssert5();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠减钱单独购）", groups = "orderinitActiviteLoseDandugou2")
    public void order_coupleorderinit_activiteLoseDandugou2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitieLosePinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "2"));
            list.add(new BasicNameValuePair("orderType", "2"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieLoseSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activiteLoseDanDetailAssert2();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠打折，打折第二件9.9折）", groups = "orderinitActiviteDiscountPintuan2")
    public void order_coupleorderinit_activiteDiscountPintuan2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitieDiscountPinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "2"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieDiscountSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activiteDiscountPinDetailAssert2();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠打折，打折第四件5折）", groups = "orderinitActiviteDiscountDandugou4")
    public void order_coupleorderinit_activiteDiscountDandugou4() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitieDiscountPinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "4"));
            list.add(new BasicNameValuePair("orderType", "2"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieDiscountSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            //coupleorderinit单独购接口的返回数据确定默认值
            HsqOpenapiConfig.coupleorderinitActiviteDiscountDandugouResult4 = result;
            activiteDiscountDanDetailAssert4();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠打折，打折第五件1折）", groups = "orderinitActiviteDiscountPintuan5")
    public void order_coupleorderinit_activiteDiscountPintuan5() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitieDiscountPinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "3"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitieDiscountSkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activiteDiscountPinDetailAssert5();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠付钱，付钱金额<订单金额）", groups = "orderinitActivitePayPintuan2")
    public void order_coupleorderinit_activitePayPintuan2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitiePayPinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "2"));
            list.add(new BasicNameValuePair("orderType", "2"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitiePaySkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activitePayPinDetailAssert2();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠付钱，付钱金额=订单金额）", groups = "orderinitActivitePayPintuan3")
    public void order_coupleorderinit_activitePayPintuan3() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitiePayPinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "3"));
            list.add(new BasicNameValuePair("orderType", "2"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitiePaySkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            activitePayPinDetailAssert3();
        }else {
            System.out.println("此环境无此case");
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "初始化订单（拼团）（营销活动+多件优惠付钱，付钱金额>订单金额）", groups = "orderinitActivitePayPintuan5")
    public void order_coupleorderinit_activitePayPintuan5() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue(2, "activitiePayPinActivitiesId")));
            list.add(new BasicNameValuePair("amount", "5"));
            list.add(new BasicNameValuePair("orderType", "2"));
            list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue(2, "activitiePaySkuId")));
            list.add(new BasicNameValuePair("conformNewUser", "1"));

            interfaces(list);
            //coupleorderinit单独购接口的返回数据确定默认值
            HsqOpenapiConfig.coupleorderinitActivitePayResult5 = result;
            activitePayPinDetailAssert5();
        }else {
            System.out.println("此环境无此case");
        }
    }




    //拼团断言,不用券
    public void pinDetailAssert() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(100, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(0, "packageInfo.platformDiscount", model.packageInfo.platformDiscount);
            detailAssertTest(11836, "packageInfo.pinActivitiesId", model.packageInfo.pinActivitiesId);
            detailAssertTest("3", "packageInfo.orderType", model.packageInfo.orderType);
            detailAssertTest(100, "needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(616, "packageInfo.itemList.get(0).merchantId", model.packageInfo.itemList.get(0).merchantId);
            detailAssertTest("蜜我食铺", "packageInfo.itemList.get(0).merchantName", model.packageInfo.itemList.get(0).merchantName);
            detailAssertTest("haoshiqi://hybrid?compid=haoshiqi&comppage=merchant&merchantid=616", "packageInfo.itemList.get(0).schema", model.packageInfo.itemList.get(0).schema);
            detailAssertTest(100, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(5000, "packageInfo.itemList.get(0).marketPrice", model.packageInfo.itemList.get(0).marketPrice);
            detailAssertTest(100, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(11836, "packageInfo.itemList.get(0).pinActivitiesId", model.packageInfo.itemList.get(0).pinActivitiesId);
            detailAssertTest("3", "packageInfo.itemList.get(0).orderType", model.packageInfo.itemList.get(0).orderType);
            detailAssertTest(28659, "packageInfo.itemList.get(0).skuList.get(0).id", model.packageInfo.itemList.get(0).skuList.get(0).id);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).source_type", model.packageInfo.itemList.get(0).skuList.get(0).source_type);
            detailAssertTest(616, "packageInfo.itemList.get(0).skuList.get(0).merchant_id", model.packageInfo.itemList.get(0).skuList.get(0).merchant_id);
            detailAssertTest(25302, "packageInfo.itemList.get(0).skuList.get(0).product_id", model.packageInfo.itemList.get(0).skuList.get(0).product_id);
            detailAssertTest("接口测试专用商品，勿动动", "packageInfo.itemList.get(0).skuList.get(0).name", model.packageInfo.itemList.get(0).skuList.get(0).name);
            detailAssertTest(100, "packageInfo.itemList.get(0).skuList.get(0).weight", model.packageInfo.itemList.get(0).skuList.get(0).weight);
            detailAssertTest(1900, "packageInfo.itemList.get(0).skuList.get(0).price", model.packageInfo.itemList.get(0).skuList.get(0).price);
            detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).thumbnail", model.packageInfo.itemList.get(0).skuList.get(0).thumbnail);
            detailAssertTest(5000, "packageInfo.itemList.get(0).skuList.get(0).market_price", model.packageInfo.itemList.get(0).skuList.get(0).market_price);
            detailAssertTest(1523873005, "packageInfo.itemList.get(0).skuList.get(0).seller_time", model.packageInfo.itemList.get(0).skuList.get(0).seller_time);
            detailAssertTest("1833552000", "packageInfo.itemList.get(0).skuList.get(0).expired_date", model.packageInfo.itemList.get(0).skuList.get(0).expired_date);
            detailAssertTest("2018-04-01", "packageInfo.itemList.get(0).skuList.get(0).manufactured_date", model.packageInfo.itemList.get(0).skuList.get(0).manufactured_date);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).enabled", model.packageInfo.itemList.get(0).skuList.get(0).enabled);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).actived", model.packageInfo.itemList.get(0).skuList.get(0).actived);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).delete_flag", model.packageInfo.itemList.get(0).skuList.get(0).delete_flag);
            detailAssertTest(1523872988, "packageInfo.itemList.get(0).skuList.get(0).created_at", model.packageInfo.itemList.get(0).skuList.get(0).created_at);
            detailAssertTest(1550815808, "packageInfo.itemList.get(0).skuList.get(0).updated_at", model.packageInfo.itemList.get(0).skuList.get(0).updated_at);
            detailAssertTest(2, "packageInfo.itemList.get(0).skuList.get(0).audit_status", model.packageInfo.itemList.get(0).skuList.get(0).audit_status);
            detailAssertTest(1523873005, "packageInfo.itemList.get(0).skuList.get(0).audit_time", model.packageInfo.itemList.get(0).skuList.get(0).audit_time);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).fpostage_amount", model.packageInfo.itemList.get(0).skuList.get(0).fpostage_amount);
            detailAssertTest(1523873005, "packageInfo.itemList.get(0).skuList.get(0).online_time", model.packageInfo.itemList.get(0).skuList.get(0).online_time);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).only_new_user", model.packageInfo.itemList.get(0).skuList.get(0).only_new_user);
            detailAssertTest("pin", "packageInfo.itemList.get(0).skuList.get(0).feature", model.packageInfo.itemList.get(0).skuList.get(0).feature);
//            detailAssertTest(1000, "packageInfo.itemList.get(0).skuList.get(0).lowest_web_price", model.packageInfo.itemList.get(0).skuList.get(0).lowest_web_price);
            detailAssertTest("1", "packageInfo.itemList.get(0).skuList.get(0).sku_order_amount", model.packageInfo.itemList.get(0).skuList.get(0).sku_order_amount);
            detailAssertTest(2592000, "packageInfo.itemList.get(0).skuList.get(0).offline_before_expired", model.packageInfo.itemList.get(0).skuList.get(0).offline_before_expired);
            detailAssertTest(616, "packageInfo.itemList.get(0).skuList.get(0).merchantId", model.packageInfo.itemList.get(0).skuList.get(0).merchantId);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).joinActivityId", model.packageInfo.itemList.get(0).skuList.get(0).joinActivityId);
            detailAssertTest(true, "packageInfo.itemList.get(0).skuList.get(0).canDelivery", model.packageInfo.itemList.get(0).skuList.get(0).canDelivery);
            detailAssertTest(11836, "packageInfo.itemList.get(0).skuList.get(0).pinActivitiesId", model.packageInfo.itemList.get(0).skuList.get(0).pinActivitiesId);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).dealAmount", model.packageInfo.itemList.get(0).skuList.get(0).dealAmount);
            detailAssertTest(100, "packageInfo.itemList.get(0).skuList.get(0).orderPrice", model.packageInfo.itemList.get(0).skuList.get(0).orderPrice);
            detailAssertTest(100, "packageInfo.itemList.get(0).skuList.get(0).dealPrice", model.packageInfo.itemList.get(0).skuList.get(0).dealPrice);
            detailAssertTest(100, "packageInfo.itemList.get(0).skuList.get(0).totalPrice", model.packageInfo.itemList.get(0).skuList.get(0).totalPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).orderAmount", model.packageInfo.itemList.get(0).skuList.get(0).orderAmount);
            detailAssertTest(28659, "packageInfo.itemList.get(0).skuList.get(0).skuId", model.packageInfo.itemList.get(0).skuList.get(0).skuId);
            detailAssertTest("接口测试专用商品，勿动动", "packageInfo.itemList.get(0).skuList.get(0).sku_name", model.packageInfo.itemList.get(0).skuList.get(0).sku_name);
            detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).skuThumbnail", model.packageInfo.itemList.get(0).skuList.get(0).skuThumbnail);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).platformDiscount", model.packageInfo.itemList.get(0).skuList.get(0).platformDiscount);
            detailAssertTest("haoshiqi://com.doweidu/couplesbuydetail?pinActivityId=11836", "packageInfo.itemList.get(0).skuList.get(0).schema", model.packageInfo.itemList.get(0).skuList.get(0).schema);
            detailAssertTest(0, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
            detailAssertTest(1, "paymentway.get(0).id", model.paymentway.get(0).id);
            detailAssertTest("微信支付", "paymentway.get(0).name", model.paymentway.get(0).name);
            detailAssertTest("http://img2.haoshiqi.net/wechatpay.png", "paymentway.get(0).icon", model.paymentway.get(0).icon);
            detailAssertTest(true, "orderAvailable", model.orderAvailable);
            detailAssertTest(1586, "address.id", model.address.id);
            detailAssertTest("上海", "address.province", model.address.province);
            detailAssertTest("上海市", "address.city", model.address.city);
            detailAssertTest("黄浦区", "address.district", model.address.district);
            detailAssertTest("测试", "address.contacter", model.address.contacter);
            detailAssertTest("测试地址", "address.detail_address", model.address.detail_address);
            detailAssertTest("138****0000", "address.mobile", model.address.mobile);
        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(2, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(2, "packageInfo.platformDiscount", model.packageInfo.platformDiscount);
            detailAssertTest(60627, "packageInfo.pinActivitiesId", model.packageInfo.pinActivitiesId);
            detailAssertTest("3", "packageInfo.orderType", model.packageInfo.orderType);
            detailAssertTest(0, "needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(1786, "packageInfo.itemList.get(0).merchantId", model.packageInfo.itemList.get(0).merchantId);
            detailAssertTest("淘食铺", "packageInfo.itemList.get(0).merchantName", model.packageInfo.itemList.get(0).merchantName);
            detailAssertTest("haoshiqi://hybrid?compid=haoshiqi&comppage=merchant&merchantid=1786", "packageInfo.itemList.get(0).schema", model.packageInfo.itemList.get(0).schema);
            detailAssertTest(2, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(3, "packageInfo.itemList.get(0).marketPrice", model.packageInfo.itemList.get(0).marketPrice);
            detailAssertTest(0, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(60627, "packageInfo.itemList.get(0).pinActivitiesId", model.packageInfo.itemList.get(0).pinActivitiesId);
            detailAssertTest("3", "packageInfo.itemList.get(0).orderType", model.packageInfo.itemList.get(0).orderType);
            detailAssertTest(85486, "packageInfo.itemList.get(0).skuList.get(0).id", model.packageInfo.itemList.get(0).skuList.get(0).id);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).source_type", model.packageInfo.itemList.get(0).skuList.get(0).source_type);
            detailAssertTest(1786, "packageInfo.itemList.get(0).skuList.get(0).merchant_id", model.packageInfo.itemList.get(0).skuList.get(0).merchant_id);
            detailAssertTest(70743, "packageInfo.itemList.get(0).skuList.get(0).product_id", model.packageInfo.itemList.get(0).skuList.get(0).product_id);
            detailAssertTest("压测专用（勿动） 200g", "packageInfo.itemList.get(0).skuList.get(0).name", model.packageInfo.itemList.get(0).skuList.get(0).name);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).weight", model.packageInfo.itemList.get(0).skuList.get(0).weight);
            detailAssertTest(3, "packageInfo.itemList.get(0).skuList.get(0).price", model.packageInfo.itemList.get(0).skuList.get(0).price);
            detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).thumbnail", model.packageInfo.itemList.get(0).skuList.get(0).thumbnail);
            detailAssertTest(3, "packageInfo.itemList.get(0).skuList.get(0).market_price", model.packageInfo.itemList.get(0).skuList.get(0).market_price);
//            detailAssertTest(3, "packageInfo.itemList.get(0).skuList.get(0).lowest_price", model.packageInfo.itemList.get(0).skuList.get(0).lowest_price);
            detailAssertTest(1557365804, "packageInfo.itemList.get(0).skuList.get(0).seller_time", model.packageInfo.itemList.get(0).skuList.get(0).seller_time);
            detailAssertTest("2127312000", "packageInfo.itemList.get(0).skuList.get(0).expired_date", model.packageInfo.itemList.get(0).skuList.get(0).expired_date);
            detailAssertTest("1994-09-01", "packageInfo.itemList.get(0).skuList.get(0).manufactured_date", model.packageInfo.itemList.get(0).skuList.get(0).manufactured_date);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).enabled", model.packageInfo.itemList.get(0).skuList.get(0).enabled);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).actived", model.packageInfo.itemList.get(0).skuList.get(0).actived);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).delete_flag", model.packageInfo.itemList.get(0).skuList.get(0).delete_flag);
            detailAssertTest(1557365778, "packageInfo.itemList.get(0).skuList.get(0).created_at", model.packageInfo.itemList.get(0).skuList.get(0).created_at);
            detailAssertTest(1558086188, "packageInfo.itemList.get(0).skuList.get(0).updated_at", model.packageInfo.itemList.get(0).skuList.get(0).updated_at);
            detailAssertTest(2, "packageInfo.itemList.get(0).skuList.get(0).audit_status", model.packageInfo.itemList.get(0).skuList.get(0).audit_status);
            detailAssertTest(1557365804, "packageInfo.itemList.get(0).skuList.get(0).audit_time", model.packageInfo.itemList.get(0).skuList.get(0).audit_time);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).fpostage_amount", model.packageInfo.itemList.get(0).skuList.get(0).fpostage_amount);
            detailAssertTest(1557365804, "packageInfo.itemList.get(0).skuList.get(0).online_time", model.packageInfo.itemList.get(0).skuList.get(0).online_time);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).only_new_user", model.packageInfo.itemList.get(0).skuList.get(0).only_new_user);
            detailAssertTest("pin,gift", "packageInfo.itemList.get(0).skuList.get(0).feature", model.packageInfo.itemList.get(0).skuList.get(0).feature);
//            detailAssertTest(3, "packageInfo.itemList.get(0).skuList.get(0).lowest_web_price", model.packageInfo.itemList.get(0).skuList.get(0).lowest_web_price);
            detailAssertTest("1", "packageInfo.itemList.get(0).skuList.get(0).sku_order_amount", model.packageInfo.itemList.get(0).skuList.get(0).sku_order_amount);
            detailAssertTest(2592000, "packageInfo.itemList.get(0).skuList.get(0).offline_before_expired", model.packageInfo.itemList.get(0).skuList.get(0).offline_before_expired);
            detailAssertTest(1786, "packageInfo.itemList.get(0).skuList.get(0).merchantId", model.packageInfo.itemList.get(0).skuList.get(0).merchantId);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).joinActivityId", model.packageInfo.itemList.get(0).skuList.get(0).joinActivityId);
            detailAssertTest(true, "packageInfo.itemList.get(0).skuList.get(0).canDelivery", model.packageInfo.itemList.get(0).skuList.get(0).canDelivery);
            detailAssertTest(60627, "packageInfo.itemList.get(0).skuList.get(0).pinActivitiesId", model.packageInfo.itemList.get(0).skuList.get(0).pinActivitiesId);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).dealAmount", model.packageInfo.itemList.get(0).skuList.get(0).dealAmount);
            detailAssertTest(2, "packageInfo.itemList.get(0).skuList.get(0).orderPrice", model.packageInfo.itemList.get(0).skuList.get(0).orderPrice);
            detailAssertTest(2, "packageInfo.itemList.get(0).skuList.get(0).dealPrice", model.packageInfo.itemList.get(0).skuList.get(0).dealPrice);
            detailAssertTest(2, "packageInfo.itemList.get(0).skuList.get(0).totalPrice", model.packageInfo.itemList.get(0).skuList.get(0).totalPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).orderAmount", model.packageInfo.itemList.get(0).skuList.get(0).orderAmount);
            detailAssertTest(85486, "packageInfo.itemList.get(0).skuList.get(0).skuId", model.packageInfo.itemList.get(0).skuList.get(0).skuId);
            detailAssertTest("压测专用（勿动） 200g", "packageInfo.itemList.get(0).skuList.get(0).sku_name", model.packageInfo.itemList.get(0).skuList.get(0).sku_name);
            detailAssertTest("packageInfo.itemList.get(0).skuList.get(0).skuThumbnail", model.packageInfo.itemList.get(0).skuList.get(0).skuThumbnail);
            detailAssertTest(0, "packageInfo.itemList.get(0).skuList.get(0).platformDiscount", model.packageInfo.itemList.get(0).skuList.get(0).platformDiscount);
            detailAssertTest("haoshiqi://com.doweidu/couplesbuydetail?pinActivityId=60627", "packageInfo.itemList.get(0).skuList.get(0).schema", model.packageInfo.itemList.get(0).skuList.get(0).schema);
            detailAssertTest(0, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
            detailAssertTest(1, "paymentway.get(0).id", model.paymentway.get(0).id);
            detailAssertTest("微信支付", "paymentway.get(0).name", model.paymentway.get(0).name);
            detailAssertTest("http://img2.haoshiqi.net/wechatpay.png", "paymentway.get(0).icon", model.paymentway.get(0).icon);
            detailAssertTest(true, "orderAvailable", model.orderAvailable);
            detailAssertTest(24113077, "address.id", model.address.id);
            detailAssertTest("上海", "address.province", model.address.province);
            detailAssertTest("上海市", "address.city", model.address.city);
            detailAssertTest("宝山区", "address.district", model.address.district);
            detailAssertTest("测试", "address.contacter", model.address.contacter);
            detailAssertTest("测试地址", "address.detail_address", model.address.detail_address);
            detailAssertTest("138****0000", "address.mobile", model.address.mobile);

        }

    }

    //单独购断言,默认用券
    public void ddgDetailAssert() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(1099, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(200, "packageInfo.platformDiscount", model.packageInfo.platformDiscount);
            detailAssertTest("2", "packageInfo.orderType", model.packageInfo.orderType);
            detailAssertTest(899, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);

            detailAssertTest(1099, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(899, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest("2", "packageInfo.itemList.get(0).orderType", model.packageInfo.itemList.get(0).orderType);
            detailAssertTest(1099, "packageInfo.itemList.get(0).skuList.get(0).orderPrice", model.packageInfo.itemList.get(0).skuList.get(0).orderPrice);
            detailAssertTest(1099, "packageInfo.itemList.get(0).skuList.get(0).dealPrice", model.packageInfo.itemList.get(0).skuList.get(0).dealPrice);
            detailAssertTest(1099, "packageInfo.itemList.get(0).skuList.get(0).totalPrice", model.packageInfo.itemList.get(0).skuList.get(0).totalPrice);
            detailAssertTest(1099, "packageInfo.itemList.get(0).needPayWithoutPlatformDiscount", model.packageInfo.itemList.get(0).needPayWithoutPlatformDiscount);

            //订单可用券相关
            detailAssertTest(2901, "avaliableCoupons.list.get(0).coupon_id", model.avaliableCoupons.list.get(0).coupon_id);
            detailAssertTest("ALL", "avaliableCoupons.list.get(0).range_type", model.avaliableCoupons.list.get(0).range_type);
            detailAssertTest(1, "avaliableCoupons.list.get(0).is_at_least", model.avaliableCoupons.list.get(0).is_at_least);
            detailAssertTest(700, "avaliableCoupons.list.get(0).at_least", model.avaliableCoupons.list.get(0).at_least);
            detailAssertTest(3, "avaliableCoupons.list.get(0).type", model.avaliableCoupons.list.get(0).type);
            detailAssertTest("满7减2", "avaliableCoupons.list.get(0).title", model.avaliableCoupons.list.get(0).title);
            detailAssertTest("全场满7元使用", "avaliableCoupons.list.get(0).sub_title", model.avaliableCoupons.list.get(0).sub_title);
            detailAssertTest(200, "avaliableCoupons.list.get(0).value", model.avaliableCoupons.list.get(0).value);
//            detailAssertTest(1558368000, "avaliableCoupons.list.get(0).start_at", model.avaliableCoupons.list.get(0).start_at);
//            detailAssertTest(1558627199, "avaliableCoupons.list.get(0).end_at", model.avaliableCoupons.list.get(0).end_at);
            detailAssertTest("全场通用", "avaliableCoupons.list.get(0).usage_title", model.avaliableCoupons.list.get(0).usage_title);
            detailAssertTest("不退款,不兑余额,不兑现金,不找零\\r\\n使用范围:全场使用", "avaliableCoupons.list.get(0).usage_desc", model.avaliableCoupons.list.get(0).usage_desc);
            detailAssertTest(0, "avaliableCoupons.list.get(0).is_expired", model.avaliableCoupons.list.get(0).is_expired);
            detailAssertTest(0, "avaliableCoupons.list.get(0).is_used", model.avaliableCoupons.list.get(0).is_used);
//            detailAssertTest(0, "avaliableCoupons.list.get(0).used_at", model.avaliableCoupons.list.get(0).used_at);
            detailAssertTest(true, "avaliableCoupons.list.get(0).selected", model.avaliableCoupons.list.get(0).selected);
            detailAssertTest(true, "avaliableCoupons.list.get(0).canUse", model.avaliableCoupons.list.get(0).canUse);
            detailAssertTest(0, "avaliableCoupons.list.get(0).weight", model.avaliableCoupons.list.get(0).weight);

        }


    }

    //参加活动报名，不用券
    public void activitiePinDetailAssert() {
        detailAssertTest(1, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(1, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(9999, "packageInfo.itemList.get(0).marketPrice", model.packageInfo.itemList.get(0).marketPrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(8888, "packageInfo.itemList.get(0).skuList.get(0).price", model.packageInfo.itemList.get(0).skuList.get(0).price);
        detailAssertTest(9999, "packageInfo.itemList.get(0).skuList.get(0).market_price", model.packageInfo.itemList.get(0).skuList.get(0).market_price);
//        detailAssertTest(8888, "packageInfo.itemList.get(0).skuList.get(0).lowest_price", model.packageInfo.itemList.get(0).skuList.get(0).lowest_price);
//        detailAssertTest(9999, "packageInfo.itemList.get(0).skuList.get(0).lowest_web_price", model.packageInfo.itemList.get(0).skuList.get(0).lowest_web_price);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).orderPrice", model.packageInfo.itemList.get(0).skuList.get(0).orderPrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).dealPrice", model.packageInfo.itemList.get(0).skuList.get(0).dealPrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).skuList.get(0).totalPrice", model.packageInfo.itemList.get(0).skuList.get(0).totalPrice);
        detailAssertTest(0, "packageInfo.itemList.get(0).discountPrice", model.packageInfo.itemList.get(0).discountPrice);
        detailAssertTest("【活动报名的前缀】接口自动化测试专用营销活动（勿动） 100g", "packageInfo.itemList.get(0).skuList.get(0).name", model.packageInfo.itemList.get(0).skuList.get(0).name);
        detailAssertTest("【活动报名的前缀】接口自动化测试专用营销活动（勿动） 100g", "packageInfo.itemList.get(0).skuList.get(0).sku_name", model.packageInfo.itemList.get(0).skuList.get(0).sku_name);


    }

    //多件优惠第二件，未达到优惠条件
    private void nolosePinDetailAssert() {
        detailAssertTest(1111, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(911, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(1111, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(911, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(0, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减11.1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第2件减11.1元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(0, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，多件优惠减钱第二件
    private void losePinDetailAssert2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(2222, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(2, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(912, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(2222, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(2, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(912, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(65, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
            detailAssertTest("第2件减11.1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
            detailAssertTest(1110, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
            detailAssertTest(1110, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
            detailAssertTest("-11.1元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
            detailAssertTest(1110, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
        }
        if ("prod".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(1332, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(2, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(0, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(1332, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(2, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(0, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(2864, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
            detailAssertTest("第2件减6.65元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
            detailAssertTest(665, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
            detailAssertTest(665, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
            detailAssertTest("-6.65元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
            detailAssertTest(665, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
        }

    }

    //多件优惠，多件优惠减钱 二三件
    private void losePinDetailAssert23() {
        detailAssertTest(3366, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(3, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(2566, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(3366, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(3, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(2566, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(66, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件减5元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest(600, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(600, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-6元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(600, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，多件优惠减钱 二四件
    private void losePinDetailAssert24() {
        detailAssertTest(4532, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(4, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(3100, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(4532, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(4, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(3100, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(67, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减11.32元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第4件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest(1232, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(1232, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-12.32元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(1232, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，多件优惠减钱 二三五件
    private void losePinDetailAssert235() {
        detailAssertTest(5720, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(4920, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(5720, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(4920, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(68, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件减2元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件减3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(600, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(600, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-6元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(600, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，多件优惠减钱 二三四五件
    private void loseDanDetailAssert2345() {
        detailAssertTest(11330, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(8123, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(11330, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(8123, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(69, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减11.54元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第4件减6元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest("第5件减11.53元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3));
        detailAssertTest(3007, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(3007, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-30.07元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(3007, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，打折，第三件
    private void discountPinDetailAssert3() {
        detailAssertTest(3333, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(3, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(2034, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(3333, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(3, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(2034, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(70, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第3件0.1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest(2199, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(1099, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-10.99元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(1099, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，打折，三四件
    private void discountPinDetailAssert34() {
        detailAssertTest(4488, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(4, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(3166, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(4488, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(4, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(3166, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(71, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第3件9.9折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第4件0.1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest(2233, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(1122, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-11.22元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(1122, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，打折，三五件
    private void discountPinDetailAssert35() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(5665, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(4332, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(5665, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(4332, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(72, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
            detailAssertTest("第3件9.9折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
            detailAssertTest("第5件0.1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
            detailAssertTest(2244, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
            detailAssertTest(1133, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
            detailAssertTest("-11.33元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
            detailAssertTest(1133, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(3330, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(1664, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(3330, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(1664, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(2865, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
            detailAssertTest("第3件9.9折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
            detailAssertTest("第5件0.1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
            detailAssertTest(888, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
            detailAssertTest(666, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
            detailAssertTest("-6.66元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
            detailAssertTest(666, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
        }

    }

    //多件优惠，打折，二四五件
    private void discountDanDetailAssert245() {
        detailAssertTest(11275, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(9722, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(11275, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(9722, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(73, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件9折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第4件8折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件7折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(1353, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(686, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-13.53元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(1353, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，打折，三五件
    private void discountPinDetailAssert2345() {
        detailAssertTest(5775, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(3150, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(5775, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(3150, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(74, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件9.9折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件0.1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第4件8折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest("第5件1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3));

        detailAssertTest(4758, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(2425, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-24.25元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(2425, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，付钱，第五件
    private void payPinDetailAssert5() {
        detailAssertTest(5555, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(5354, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(5555, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(5354, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(75, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第5件11.1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest(1112, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(1, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-0.01元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(1, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，付钱，四五件
    private void payDanDetailAssert45() {
        detailAssertTest(11165, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(7000, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(11165, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(7000, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(76, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第4件5元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第5件0.01元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest(3965, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(1743, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-39.65元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(3965, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，付钱，二五件
    private void payPinDetailAssert25() {
        detailAssertTest(5665, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(4332, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(5665, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(4332, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(77, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件0.01元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第5件11.32元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest(3355, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(1133, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-11.33元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(1133, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，付钱，二三五件
    private void payPinDetailAssert235() {
        detailAssertTest(5720, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(4032, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(5720, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(4032, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(78, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第3件11.43元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第4件8元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件0.01元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(4821, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(1488, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-14.88元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(1488, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //多件优惠，付钱，二三四五件
    private void payPinDetailAssert2345() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(5775, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(3410, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(5775, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(3410, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(79, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
            detailAssertTest("第2件11.54元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
            detailAssertTest("第3件8元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
            detailAssertTest("第4件0.01元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
            detailAssertTest("第5件5元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3));
            detailAssertTest(6609, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
            detailAssertTest(2165, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
            detailAssertTest("-21.65元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
            detailAssertTest(2165, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(3330, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(867, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(3330, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(867, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(2866, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
            detailAssertTest("第2件5元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
            detailAssertTest("第3件4元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
            detailAssertTest("第4件3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
            detailAssertTest("第5件0.01元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3));
            detailAssertTest(2351, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
            detailAssertTest(1463, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
            detailAssertTest("-14.63元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
            detailAssertTest(1463, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

        }

    }

    //多件优惠，付钱，二三四五件(未达到第五件优惠)
    private void noPayPinDetailAssert2345() {
        detailAssertTest(4620, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(4, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(2910, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(4620, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(4, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(2910, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(79, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件11.54元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件8元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第4件0.01元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest("第5件5元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(3));
        detailAssertTest(4843, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(1510, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("已优惠15.1元,第5件5元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(1510, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //营销活动+多件优惠，减钱金额>订单金额
    private void activiteLosePinDetailAssert2() {
        detailAssertTest(600, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(2, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(300, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(600, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(2, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(300, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(83, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减9元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件减3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第4件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(900, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(300, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("已优惠3元,第3件减3元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(300, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //营销活动+多件优惠，减钱金额=订单金额
    private void activiteLosePinDetailAssert3() {
        detailAssertTest(900, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(3, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(300, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(900, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(3, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(300, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(83, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减9元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件减3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第4件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(1200, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(600, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("已优惠6元,第4件减1元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(600, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //营销活动+多件优惠，减钱金额<订单金额
    private void activiteLosePinDetailAssert4() {
        detailAssertTest(1200, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(4, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(500, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(1200, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(4, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(500, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(83, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减9元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件减3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第4件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(1300, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(700, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-7元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(700, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //营销活动+多件优惠+优惠券
    private void activiteLosePinDetailAssert5() {
        detailAssertTest(1500, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(600, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(1500, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(600, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(83, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减9元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件减3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第4件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(1300, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(700, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-7元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(700, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //营销活动+多件优惠，减钱金额>订单金额单独够
    private void activiteLoseDanDetailAssert2() {
        detailAssertTest(17776, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(2, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(16676, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(17776, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(2, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(16676, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(83, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件减9元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件减3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第4件减1元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(900, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(300, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("已优惠9元,第3件减3元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(900, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //营销活动+多件优惠，打折第二件9.9折
    private void activiteDiscountPinDetailAssert2() {
        detailAssertTest(600, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(2, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(597, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(600, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(2, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(597, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(84, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件9.9折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第4件5折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(88, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(3, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("已优惠0.03元,第4件5折", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(3, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
    }

    //营销活动+多件优惠，打折第4件5折
    private void activiteDiscountDanDetailAssert4() {
        detailAssertTest(35552, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(4, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(30820, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(35552, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(4, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(30820, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(84, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件9.9折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第4件5折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(4532, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(153, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("已优惠45.32元,第5件1折", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(4532, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
    }

    //营销活动+多件优惠，打折第五件1折
    private void activiteDiscountPinDetailAssert5() {
        detailAssertTest(1500, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(877, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(1500, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(877, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(84, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件9.9折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第4件5折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件1折", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(12532, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(423, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-4.23元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(423, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
    }

    //营销活动+多件优惠，付钱金额<订单金额
    private void activitePayPinDetailAssert2() {
        detailAssertTest(17776, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(2, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(8888, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(17776, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(2, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(8888, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(85, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件2元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件20元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(8688, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(100, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("已优惠86.88元,第3件3元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(8688, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //营销活动+多件优惠，付钱金额=订单金额
    private void activitePayPinDetailAssert3() {
        detailAssertTest(26664, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(3, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(9188, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(26664, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(3, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(9188, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(85, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件2元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件20元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(17276, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(100, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("已优惠172.76元,第5件20元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(17276, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }

    //营销活动+多件优惠，付钱金额>订单金额
    private void activitePayPinDetailAssert5() {
        detailAssertTest(44440, "packageInfo.totalPrice", model.packageInfo.totalPrice);
        detailAssertTest(5, "packageInfo.totalAmount", model.packageInfo.totalAmount);
        detailAssertTest(20076, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
        detailAssertTest(44440, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
        detailAssertTest(5, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
        detailAssertTest(20076, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
        detailAssertTest(85, "packageInfo.itemList.get(0).discountActivity.discountActivityId", model.packageInfo.itemList.get(0).discountActivity.discountActivityId);
        detailAssertTest("第2件2元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(0));
        detailAssertTest("第3件3元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(1));
        detailAssertTest("第5件20元", "packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2)", model.packageInfo.itemList.get(0).discountActivity.shopDiscount.get(2));
        detailAssertTest(24164, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountSinglePrice);
        detailAssertTest(100, "packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice", model.packageInfo.itemList.get(0).discountActivity.discountPinPrice.discountGroupPrice);
        detailAssertTest("-241.64元", "packageInfo.itemList.get(0).discountActivity.latelyDoubleTips", model.packageInfo.itemList.get(0).discountActivity.latelyDoubleTips);
        detailAssertTest(24164, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

    }


    //抽奖团拼团
    private void chouPinDetailAssert() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {

            detailAssertTest(299, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(299, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(299, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(299, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(0, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {

            detailAssertTest(1, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(1, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(1, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(0, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);

        }

    }

    //抽奖团单独购
    private void chouDdgDetailAssert() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {

            detailAssertTest(10099, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(10099, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(10099, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(10099, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(0, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {

            detailAssertTest(2, "packageInfo.totalPrice", model.packageInfo.totalPrice);
            detailAssertTest(1, "packageInfo.totalAmount", model.packageInfo.totalAmount);
            detailAssertTest(2, "packageInfo.needPayPrice", model.packageInfo.needPayPrice);
            detailAssertTest(2, "packageInfo.itemList.get(0).totalPrice", model.packageInfo.itemList.get(0).totalPrice);
            detailAssertTest(1, "packageInfo.itemList.get(0).totalAmount", model.packageInfo.itemList.get(0).totalAmount);
            detailAssertTest(2, "packageInfo.itemList.get(0).needPayPrice", model.packageInfo.itemList.get(0).needPayPrice);
            detailAssertTest(0, "packageInfo.doubleDiscount", model.packageInfo.doubleDiscount);
        }


    }




}
