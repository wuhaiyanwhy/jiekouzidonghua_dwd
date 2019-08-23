package com.duoweidu.model.fyb;

import java.util.ArrayList;

public class UserGetusercartData {

    public ArrayList<ListModel> list;
    public int singleSkuCnt;
    public int totalSkuCnt;
    public int expiredTime;
    public int totalCartSkuCnt;
    public int activeVoucherMoney;
    public int notActiveVoucherMoney;
    public int hasInvited;
    public int hasNewUserBenefit;
//    public String defaultDeductibleRate;

    public static class ListModel {
        public int weight;
        public int only_new_user;
        public int buy_limit_amount;
        public int id;
        public String user_id;
        public int merchant_id;
        public int product_id;
        public int sku_id;
        public int amount;
        public int unit_price;
        public int market_price;
        public int total_price;
        public ArrayList<AttributeTagsModel> attribute_tags;
        public String sku_thumbnail;
        public String sku_name;
        public int fpostage_amount;
        public int restriction_amount;
        public int left_stock;
        public int maxCartSkuCnt;
        public int remainderCartSkuCnt;
        public int offline_before_expired;
        public String expired_date;
        public int enabled;
        public int skuId;
        public int productId;
        public int merchantId;
        public String name;
        public String skuThumbnail;
        public int lowest_price;
        public int price;
        public int seller_time;
        public int boughtCnt;
        public int waitPayCnt;
        public ArrayList<AttrsModel> attrs;
        public int sourceType;

        public static class AttributeTagsModel {
            public String name;
            public String value;
        }

        public static class AttrsModel {
            public String name;
            public String value;

        }

    }
}
