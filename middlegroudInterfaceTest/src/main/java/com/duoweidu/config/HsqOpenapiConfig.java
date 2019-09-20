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
    public static  String goconfirmSid;
    //保存购物车普通订单的id
    public static String orderIds;

    //储存riskgo是否更新接口的值
    public static int riskgoSwitch;
}
