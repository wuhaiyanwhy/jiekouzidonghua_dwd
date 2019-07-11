package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class OrderCheckpromotionData {

    public ArrayList<CouponListModel> couponList;
    public ArrayList<SkusInfoModel> skusInfo;
    public ArrayList<DiscountInfoModel> discountInfo;

    public static class CouponListModel {
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

    public static class SkusInfoModel {
        public String skuId;
        public String amount;
        public String price;

    }

    public static class DiscountInfoModel {
        public ArrayList<MerchantPriceModel> merchantPrice;
        public int platformDiscount;
        public int totalNeedPay;
        public static class MerchantPriceModel {
            public int merchant_id;
            public int merchantId;
            public int needPayWithoutPlatformDiscount;
            public int discount;
            public int couponDiscount;
            public int platformDiscount;
            public int needPay;

        }

    }
}
