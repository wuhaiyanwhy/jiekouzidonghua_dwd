package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class OrderWaitcommentlistData {

    public ArrayList<ListModel> list;
    public int totalCnt;
    public int totalPage;

    public static class ListModel {
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
        public ArrayList<String> attribute_tags;
        public int status;
        public int comment_status;
        public int is_free;
        public String created_at;
        public String updated_at;
        public int platform_discount;
        public int merchant_discount;
        public int settlement_price;
        public int settlement_way;
        public String confirm_time;
        public int pin_activities_id;
        public String pin_event_id;
        public int point;
        public int source_type;
        public int order_type;
        public int saved_money;
        public int skuId;
        public String orderId;
        public String name;
        public int subOrderId;
        public String skuThumbnail;
        public ArrayList<String> attrs;
        public int orderType;
        public int pinActivitiesId;
        public String schema;



    }
}
