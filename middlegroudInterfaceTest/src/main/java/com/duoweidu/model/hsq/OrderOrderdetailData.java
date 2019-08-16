package com.duoweidu.model.hsq;

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
    public int pay_time;
    public int delivery_time;
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
    public int created_at;
    public int updated_at;
    public int order_type;
    public int pin_activities_id;
    public int pin_event_id;
    public int point_payment_id;
    public int payways;
    public String pay_info;
    public String payment_method;
    public String third_party_no;
    public int saved_money;
    public String solicitation_time;
    public String deductible_amount;
    public String premium_income;
    public int sham_total_price;
    public String merchant_order_note;
    public String spm;
    public int expire_ack_time;
    public String cps_name;
    public ArrayList<OrderGetuserordersData.ListModel.SkuListModel> skuList;
    public String coupleTime;
    public String coupleStatus;
    public String restCount;
    public String pinEventId;
    public String orderType;
    public String pinStatusDesc;
    public String pinStatusLink;
    public String isOwner;
    public ProductCoupleskudetailData.ShareInfoModel shareInfo;
    public String merchantName;
    public String udesk_merchant_id;
    public String serviceTel;
    public int merchantId;
    public String orderId;
    public int productsPrice;
    public int refundId;
    public boolean canRefund;
    public int deliveryWay;
    public int sourceType;
    public String schema;
    public boolean canCancel;
    public int statusCode;
    public boolean canViewDelivery;
    public String statusLogo;
    public ArrayList<String> stepList;
    public MessageModel message;

    public static class MessageModel {
        public String id;
        public int channel_id;
        public int position;
        public String start_time;
        public String end_time;
        public String title;
        public String content;
        public int status;
        public int is_deleted;

    }

}
