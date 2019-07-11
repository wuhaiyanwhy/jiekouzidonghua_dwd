package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class TradecenterAssistanceorderinitData {

    public AddressModel address;
    public PackageInfoModel packageInfo;
    public ArrayList<PaymentwayModel> paymentway;
    public String confirmSid;

    public static class AddressModel{
        public int id;
        public String province;
        public String city;
        public String district;
        public String contacter;
        public String detail_address;
        public String mobile;
    }
    public static class PackageInfoModel{
        public int totalPrice;
        public int totalAmount;
        public int activityId;
        public int orderType;
        public int needPayPrice;
        public ArrayList<ItemListModel> itemList;

        public static class ItemListModel {
            public int merchantId;
            public String merchantName;
            public String schema;
            public int freeDeliveryPrice;
            public int isFreeDelivery;
            public int totalPrice;
            public int totalAmount;
            public int marketPrice;
            public int needPayPrice;
            public int activityId;
            public int activityEventId;
            public int orderType;
            public ArrayList<SkuListModel>  skuList;
            public int discountPrice;
            public int platformDiscount;
            public int join_times_limit;

            public static class SkuListModel {
                public int id;
                public int source_type;
                public int merchant_id;
                public int product_id;
                public String name;
                public int weight;
                public int price;
                public String thumbnail;
                public int market_price;
                public int lowest_price;
                public int seller_time;
                public int expired_date;
                public String manufactured_date;
                public int enabled;
                public int liked_cnt;
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
                public ArrayList<AttrsModel> attrs;
                public String sku_order_amount;
                public int offline_before_expired;
                public int merchantId;
                public int joinActivityId;
                public boolean canDelivery;
                public int activityId;
                public int dealAmount;
                public int orderPrice;
                public int dealPrice;
                public int totalPrice;
                public int left_stock;
                public int leftStock;
                public int orderAmount;
                public int skuId;
                public String sku_name;
                public ArrayList<AttrsModel> attribute_tags;
                public int productId;
                public String skuThumbnail;
                public int platformDiscount;
                public int remainderCartSkuCnt;
                public int maxCartSkuCnt;
                public String schema;

                public static class AttrsModel {
                    public String name;
                    public String value;
                }

            }

        }

    }

    public static class PaymentwayModel{
        public int id;
        public String name;
        public String icon;
    }

}
