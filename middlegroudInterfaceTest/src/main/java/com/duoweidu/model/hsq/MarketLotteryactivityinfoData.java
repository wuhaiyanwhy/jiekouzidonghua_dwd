package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class MarketLotteryactivityinfoData {

    public int status;
    public int canBuy;
    public int canSub;
    public int canUnSub;
    public int pinActivitiesId;
    public int type;
    public String title;
    public int startTime;
    public int endTime;
    public int groupPrice;
    public int marketPrice;
    public int remindStatus;
    public int lotteryTime;
    public int hasBeenLottery;
    public int skuId;
    public int productId;
    public int joinCount;
    public String rule;
    public String ruleUrl;
    public int countLimit;
    public int joinTimesLimit;
    public int singlePrice;
    public SkuInfoModel skuInfo;
    public ShareInfo shareInfo;
    public String schema;
    public String h5Link;

    public static class SkuInfoModel {
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
        public int manufactured_date;
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
        public ArrayList<AttrsModel> attrs;
        public boolean canDelivery;
        public ArrayList<AttrOptionsModel> attrOptions;
        public String batch;
        public ArrayList<String> pics;
        public int offline_before_expired;
        public String description;
        public ArrayList<LabelsModel> labels;
        public int skuId;
        public int productId;
        public int merchantId;
        public UgcBriefModel ugcBrief;
        public int left_stock;
        public MerchantInfoModel merchantInfo;
        public int canBuy;
        public String pricePrefix;
        public int maxCartSkuCnt;
        public int remainderCartSkuCnt;



        public static class AttrsModel {
            public String name;
            public String value;
        }

        public static class AttrOptionsModel {
            public String name;
            public ArrayList<Submodel121> list;

            public static class Submodel121 {
                public String value;
                public int skuId;
            }
        }

        public static class LabelsModel {
            public String icon;
            public String text;
            public String link;

        }

        public static class UgcBriefModel {
            public ArrayList list;
            public int totalCnt;
        }

        public static class MerchantInfoModel {
            public int id;
            public int roles;
            public String name;
            public String tinyurl;
            public String logo;
            public String description;
            public int online_sku_cnt;
            public int free_delivery_price;
            public int is_free_delivery;
            public int enabled;
            public int is_free_base_weight;
            public String notice;
            public String vendor_notice;
            public String udesk_merchant_id;
            public String province;
            public String city;
        }
    }

    public static class ShareInfo {
        public ShareInfoModel firendsZone;
        public ShareInfoModel wechat;
        public ShareInfoModel mobileQQ;

        public static class ShareInfoModel {
            public String title;
            public String content;
            public String thumbnail;
            public String link;

        }

    }

}
