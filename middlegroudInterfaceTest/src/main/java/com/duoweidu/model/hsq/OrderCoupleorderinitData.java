package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class OrderCoupleorderinitData {

    public PackageInfoModel packageInfo;
    public ArrayList<PaymentwayModel> paymentway;
    public boolean orderAvailable;
    public AvaliableCouponsModel avaliableCoupons;
    public AddressModel address;
    public String confirmSid;

    public static class PackageInfoModel {
        public int totalPrice;
        public int totalAmount;
        public int platformDiscount;
        public int pinActivitiesId;
        public String orderType;
        public int needPayPrice;
        public ArrayList<ItemListModel> itemList;
        public int doubleDiscount;

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
            public int pinActivitiesId;
            public String orderType;
            public ArrayList<SkuListModel>  skuList;
            public int discountPrice;
            public int platformDiscount;
            public int needPayWithoutPlatformDiscount;
            public DiscountActivityModel discountActivity;
            public boolean isLightMemberOrder;

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
                public String expired_date;
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
                public ArrayList attrs;
                public String sku_order_amount;
                public int offline_before_expired;
                public int merchantId;
                public int joinActivityId;
                public boolean canDelivery;
                public int pinActivitiesId;
                public int dealAmount;
                public int orderPrice;
                public int dealPrice;
                public int totalPrice;
                public int left_stock;
                public int leftStock;
                public int orderAmount;
                public int skuId;
                public String sku_name;
                public ArrayList attribute_tags;
                public int productId;
                public String skuThumbnail;
                public int platformDiscount;
                public int remainderCartSkuCnt;
                public int maxCartSkuCnt;
                public String schema;

            }

            public static class DiscountActivityModel {
                public int discountActivityId;
                public ArrayList<String> shopDiscount;
                public DiscountPinPriceModel discountPinPrice;
                public String latelyDoubleTips;
                public static class DiscountPinPriceModel {
                    public int discountSinglePrice;
                    public int discountGroupPrice;
                }

            }

        }


    }

    public static class PaymentwayModel {
        public int id;
        public String name;
        public String icon;
    }

    public static class AvaliableCouponsModel {
        public ArrayList<ListModel> list;
        public int totalCnt;

        public static class ListModel {
//            "coupon_id":2901,
//            "coupon_code":"1B4L5SDXD2I28LPRUAZR",
//            "range_type":"ALL",
//            "is_at_least":1,
//            "at_least":700,
//            "type":3,
//            "title":"满7减2",
//            "sub_title":"全场满7元使用",
//            "value":200,
//            "start_at":1558368000,
//            "end_at":1558627199,
//            "usage_title":"全场通用",
//            "usage_desc":"不退款,不兑余额,不兑现金,不找零\r\n使用范围:全场使用",
//            "is_expired":0,
//            "is_used":0,
//            "created_at":1558417959,
//            "used_at":0,
//            "selected":true,
//            "canUse":true,
//            "weight":0
            public int coupon_id;
            public String coupon_code;
            public String range_type;
            public int is_at_least;
            public int at_least;
            public int type;
            public String title;
            public String sub_title;
            public int value;
            public int start_at;
            public int end_at;
            public String usage_title;
            public String usage_desc;
            public int is_expired;
            public int is_used;
            public int created_at;
            public int used_at;
            public boolean selected;
            public boolean canUse;
            public int weight;
        }
    }

    public static class AddressModel {
        public int id;
        public String province;
        public String city;
        public String district;
        public String contacter;
        public String detail_address;
        public String mobile;
    }
}
