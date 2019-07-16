package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class TradecenterOrderlistData {

    public ArrayList<ListModel> list;
    public int totalPage;
    public int totalCnt;

    public static class ListModel {

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
        public ArrayList<SkuListModel> skuList;
        public boolean canRefund;
        public String merchantName;
        public String serviceTel;
        public boolean canCancel;
        public String statusDesc;
        public String statusLogo;

        public int refundId;
        public int refundStatus;
        public String refundStatusDesc;

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
            public ArrayList<AttrsModel> attrs;
            public boolean canRefund;

            public static class AttrsModel{
                public String 规格;
                public String 批次;
            }
        }
    }
}
