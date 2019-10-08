package com.duoweidu.config;

import java.util.ArrayList;
import java.util.List;

public class HsqOpenapiConfig {

    //储存orderinit接口返回信息
    public static String orderinitResult;
    //储存coupleorderinit拼团接口返回的信息
    public static String coupleorderinitPintuanResult;
    //储存coupleorderinit拼团接口返回的信息
    public static String coupleorderinitActivitiePintuanResult;
    //多件优惠
    public static String coupleorderinitLosePintuanResult2;
    //拼团活动+多件优惠
    public static String coupleorderinitActivitePayResult5;
    public static String coupleorderinitActiviteDiscountDandugouResult4;

    //储存coupleorderinit单独购接口返回的信息
    public static String coupleorderinitDandugouResult;
    //储存addaddress接口返回的信息
    public static String addaddressResult;

    //储存submitorder普通接口返回的信息
    public static String submitorderPutongResult;
    //储存submitorder拼团接口返回的信息
    public static String submitorderPintuanResult;
    //储存submitorder单独够接口返回的信息
    public static String submitorderDandugouResult;

    //储存orderpay普通接口返回的信息
    public static String orderpayPutongResult;
    //储存submitorder拼团接口返回的信息
    public static String orderpayPintuanResult;
    //储存submitorder单独够接口返回的信息
    public static String orderpayDandugouResult;
    //断言失败了存数据
    public static List<String> errnoList = new ArrayList<>();
    //储存切换确认订单-选择优惠券，优惠券id和code码
    public static int couponId;
    public static String couponCode;
    //储存发起助力返回的event_id
    public static int activityEventId;
    //储存助力免单订单初始化接口返回的confirmSid
    public static String activityConfirmSid;
    //储存助力免单订单初始化接口返回的地址id
    public static int activityAddressId;
    //储存信用购返回的confirmSid
    public static String xinyongConfirmSid;
    //储存信用购返回的地址id
    public static int xinyongAddressId;
    //储存信用购订单初始化接口返回的接口信息
    public static String orderInitResult;
    //储存积分订单列表接口返回的总页数
    public static int totalPage;
    //保存普通订单临时id
    public static String goconfirmSid;
    //保存购物车普通订单的id
    public static String orderIds;


    //储存riskgo是否更新接口的值
    public static int riskgoSwitch;
    //保存普通订单临时id (商家优惠券2件)
    public static String merchantConfirmSid;
    public static String confirmSidNoLose2;
    public static String confirmSidLose2;
    public static String confirmSidLose23;
    public static String confirmSidLose24;
    public static String confirmSidLose235;
    public static String confirmSidDiscount3;
    public static String confirmSidDiscount34;
    public static String confirmSidDiscount35;
    public static String confirmSidDiscount245;
    public static String confirmSidDiscount2345;
    public static String confirmSidPay5;
    public static String confirmSidPay45;
    public static String confirmSidPay25;
    public static String confirmSidPay345;
    public static String confirmSidPay2345;
    public static String coupleorderinitChouPintuanResult;
    public static String submitorderChouPintuanResult;
    public static String coupleorderinitChouDandugouResult;
    public static String submitorderChouDandugouResult;
    public static String coupleorderinitNoLosePintuanResult2;
    public static String coupleorderinitLosePintuanResult23;
    public static String coupleorderinitLosePintuanResult24;
    public static String coupleorderinitLosePintuanResult235;
    public static String coupleorderinitLoseDandugouResult2345;
    public static String coupleorderinitDiscountPintuan3;
    public static String coupleorderinitDiscountPintuan34;
    public static String coupleorderinitDiscountPintuan35;
    public static String coupleorderinitDiscountPintuan2345;
    public static String coupleorderinitPayPintuan2345;
    public static String coupleorderinitPayPintuan5;
    public static String coupleorderinitPayPintuan25;
    public static String coupleorderinitPayPintuan235;
    public static String coupleorderinitPayDandugou45;
    public static String coupleorderinitNoPayPintuan2345;
    public static String coupleorderinitActiviteLosePintuan2;
    public static String coupleorderinitActiviteLosePintuan3;
    public static String coupleorderinitActiviteLosePintuan4;
    public static String coupleorderinitActiviteLosePintuan5;
    public static String coupleorderinitActiviteLoseDandugou2;
    public static String coupleorderinitActiviteDiscountPintuan2;
    public static String coupleorderinitActiviteDiscountPintuan5;
    public static String coupleorderinitActivitePayResult2;
    public static String coupleorderinitActivitePayResult3;
    public static String coupleorderinitDiscountDandugou245;
}
