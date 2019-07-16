package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class TradecenterOrderinfoData {

    public String id;
    public int status;
    public String consignee;
    public String note;
    public int payways;
    public String orderId;
    public int userId;
    public int merchantId;
    public int addressId;
    public int pointPaymentId;
    public int point_payment_id;
    public int orderType;
    public int deliveryType;
    public int invoiceType;
    public String invoiceTitle;
    public String consigneePhone;
    public int needPayPrice;
    public int payPrice;
    public int totalPrice;
    public int deliveryPrice;
    public int merchantDiscount;
    public int platformDiscount;
    public int totalPoint;
    public int totalAmount;
    public int deliveryStatus;
    public int commentStatus;
    public String deliveryProvince;
    public String deliveryCity;
    public String deliveryDistrict;
    public String deliveryDetailAddress;
    public String payTime;
    public int deliveryTime;
    public int confirmTime;
    public int createdAt;
    public int updatedAt;
    public int discountPrice;

    public int saved_money;
    public int solicitation_time;
    public int deductible_amount;
    public int premium_income;
    public int sham_total_price;
    public String merchant_order_note;
    public String cps_name;

    public int expire_ack_time;


    public ArrayList<SkuListModel> skuList;

    public boolean canRefund;
    public String merchantName;
    public String serviceTel;
    public boolean canCancel;
    public String statusDesc;
    public String statusLogo;
    public String udesk_merchant_id;
    public String udesk_merchant_name;
    public int custom_service_id;
    public MessageModel message;

    public int refundId;
    public int refundStatus;
    public String refundStatusDesc;
    public boolean canViewDelivery;

    public static class SkuListModel {

        public String id;
        public int amount;
        public int status;
        public int point;
        public String attribute_tags;
        public int userId;
        public String orderId;
        public int productId;
        public int buSkuId;
        public int skuId;
        public String skuName;
        public String skuThumbnail;
        public int marketPrice;
        public int totalPrice;
        public int payPrice;
        public int unitPrice;
        public int commentStatus;
        public int createdAt;
        public int updatedAt;
        public int confirmTime;
        public int platform_discount;
        public int saved_money;
        public int discount_price;
        public ArrayList<PointIteminfoData.AttrsModel> attrs;
        public boolean canRefund;

    }

    public static class MessageModel {

        public int id;
        public int channel_id;
        public int position;
        public int start_time;
        public int end_time;
        public String title;
        public String content;
        public int status;
        public int is_deleted;
    }

}
