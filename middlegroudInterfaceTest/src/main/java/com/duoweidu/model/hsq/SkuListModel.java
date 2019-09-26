package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class SkuListModel {

    public int id;
    public int merchant_id;
    public int product_id;
    public String name;
    public int weight;
    public int price;
    public String thumbnail;
    public int market_price;
    public int lowest_price;
    public int seller_time;
    public String expired_date;
    public String manufactured_date;
    public int enabled;
    public int liked_cnt;
    public int ugc_cnt;
    public int selled_cnt;
    public String merchant_item_code;
    public int actived;
    public int delete_flag;
    public int created_at;
    public int updated_at;
    public int audit_status;
    public int audit_time;
    public int restriction_amount;
    public int fpostage_amount;
    public int online_time;
    public int only_new_user;
    public String feature;
    public int lowest_web_price;
    public int version_id;
    public int offline_before_expired;
    public int merchantId;
    public int joinActivityId;
    public boolean canDelivery;
    public int dealAmount;
    public String dealPrice;
    public int totalPrice;
    public int left_stock;
    public int max_cart_nums;
    public int amount;
    public String orderPrice;
    public int skuId;
    public String sku_name;
    public ArrayList<AttrsModel> attrs;
    public ArrayList<String> attrs_desc;
    public int productId;
    public String skuThumbnail;
    public int sourceType;
    public int double_discount_price;
    public DiscountActivityModel discount_activity;
    public String pic;
    public int active;
    public String schema;

    public static class AttrsModel {
        public String name;
        public String value;
    }

    public static class DiscountActivityModel {
        public int discount_activity_id;
        public int discount_price;
        public ArrayList<String> shop_discount;
    }

}
