package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class OrderOrderdetailData {

    public String id;
    public int user_id;
    public int merchant_id;
    public String status;
    public int delivery_status;
    public int comment_status;
    public int merchant_discount;
    public int platform_discount;
    public int market_price;
    public int pay_price;
    public int pay_id;
    public int need_pay_price;
    public int discount_price;
    public int delivery_price;
    public int total_price;
    public int total_amount;
    public String pay_time;
    public String delivery_time;
    public int confirm_time;
    public int address_id;
    public int delivery_type;
    public int delivery_fee_way;
    public int is_delivery_free;
    public String note;
    public String delivery_province;
    public int invoice_type;
    public String invoice_title;
    public String delivery_city;
    public String delivery_district;
    public String delivery_detail_address;
    public String consignee;
    public String consignee_phone;
    public String created_at;
    public String updated_at;
    public int order_type;
    public String pin_activities_id;
    public String pin_event_id;
    public String point_payment_id;
    public int payways;
    public String pay_info;

    public ArrayList<OrderGetuserordersData.ListModel.SkuListModel> skuList;

    public int refundId;
    public String refundStatusDesc;
    public String merchantName;
    public int merchantId;
    public String orderId;
    public int deliveryWay;
    public int sourceType;
    public boolean canRefund;
    public boolean canCancel;
    public int order_status;
    public int statusCode;
    public int shareStatus;
    public int shareAmount;
    //订单详情接口需要的参数
    public int premium_income;
    public int sham_total_price;

    public static class SkuListModel {
        public int id;
        public int user_id;
        public String order_id;
        public int product_id;
        public int sku_id;
        public int bu_sku_id;
        public String sku_name;
        public String sku_thumbnail;
        public int unit_price;
        public int market_price;
        public int amount;
        public int total_price;
        public int discount_price;
        public int pay_price;
        public ArrayList<OrderGetuserordersData.ListModel.SkuListModel.AttributeTagsModel> attribute_tags;
        public int status;
        public int comment_status;
        public int is_free;
        public String created_at;
        public String updated_at;
        public String last_update;
        public int platform_discount;
        public int merchant_discount;
        public int settlement_price;
        public int settlement_way;
        public int confirm_time;
        public int pin_activities_id;
        public int pin_event_id;
        public int point;
        public int source_type;
        public int saved_money;
        public ArrayList<String> refundInfo;
        public int skuId;
        public String orderId;
        public int userId;
        public String name;
        public String skuThumbnail;
        public int productId;
        public ArrayList<String> attrs;

        public static class AttributeTagsModel {
            public String name;
            public String value;
        }

    }
}
