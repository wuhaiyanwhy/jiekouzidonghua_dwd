package com.duoweidu.config;

/**
 * 储存tradecnter相关数据
 */
public class TradecenterConfig {

    //账户类别 选择使用通用断言
    public static String accountType = "";

    //储存创建账户接口返回的账户账号
    public static String msfAccountNumber;
    public static String iqgNewAccountNumber;
    public static String iqgAccountNumber;
    public static String jszAccountNumber;

    //创建充值单返回的tradeNo
    public static String msfCreateRechargeTradeNo;
    public static String iqgCreateRechargeTradeNo;
    public static String msfCreateAdjustTradeNo;
    public static String iqgCreateAdjustTradeNo;
    public static String msfCreateOrderOrderNo;
    public static String iqgCreateOrderOrderNo;
    public static String jszCreateOrderOrderNo;
    public static String msfCreateOrderSubOrderNo;
    public static String iqgCreateOrderSubOrderNo;
    public static String jszCreateOrderSubOrderNo;
    public static String msfCreatePayTradeNo;
    public static String iqgCreatePayTradeNo;
    public static String jszCreatePayTradeNo;
    public static String msfCreateRefundTradeNo;
    public static String iqgCreateRefundTradeNo;
    public static String jszCreatePaySettleTradeNo;
    public static String jszCreateSettleOrderOrderNo;
    public static String jszCreateSettleOrderSubOrderNo;
    public static String jszCreateWithdrawTradeNo;
}
