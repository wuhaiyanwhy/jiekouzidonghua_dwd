package com.duoweidu.model.hsq;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductCoupleskudetailData {

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

    public int couplePrice;
    public int singlePrice;
    public int coupleEndTime;
    public int startTime;
    public int countLimit;
    public int offline_before_expired;
    public String description;
    public boolean coupleIsOnline;
    public boolean canDelivery;
    public ArrayList<AttrKeysModel> attrKeys;
    public HashMap<String, AttrDatasModel> attrDatas;
    public FastJoinListModel fastJoinList;
    public ArrayList<AttrOptionsModel> attrOptions;
    public String batch;
    public ArrayList<String> pics;
    public ArrayList<LabelsModel> labels;
    public int skuId;
    public int productId;
    public int merchantId;
    public UgcBriefModel ugcBrief;
    public int left_stock;
    public MerchantInfoModel merchantInfo;
    public boolean singeCanBought;
    public boolean coupleCanBought;
    public String coupleRuleUrl;
    public String pricePrefix;
    public int maxCartSkuCnt;
    public String schema;
    public String h5Link;
    public boolean is_like;
    public ActivityPreheatModel activityPreheat;
    public ArrayList<String> shopDiscount;
    public ShareInfoModel shareInfo;
    public int remainderCartSkuCnt;
    public int merchant_type;

    public static class AttrsModel {
        public String name;
        public String value;
    }

    public static class AttrKeysModel {
        public ArrayList<ListModel> list;
        public String name;
        public String defaultAttr;

        public static class ListModel {
            public HashMap<String, String> listData;
        }
    }

    public static class AttrDatasModel {
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
        public int left_stock;
        public int pinactivitiesid;


    }

    public static class FastJoinListModel {
        public ArrayList<ListModel> list;
        public int totalCnt;

        public static class ListModel{

        }
    }

    public static class AttrOptionsModel {
        public String name;
        public ArrayList<ListModel> list;

        public static class ListModel{
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
        public ArrayList<ListModel> list;
        public int totalCnt;

        public static class ListModel {

        }
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
        public ArrayList<PromotionsModel> promotions;
        public String province;
        public String city;
        public String schema;


        public static class PromotionsModel {
            public String icon;
            public String text;
        }
    }

    public static class ActivityPreheatModel {
        public int activityId;
        public int activityTopicId;
        public int activityPrice;
        public int marketPrice;
        public int activityStock;
        public int startTime;
        public int endTime;

    }
    public static class ShareInfoModel {
        public FirendsZoneModel firendsZone;
        public WechatModel wechat;
        public MobileQQModel mobileQQ;
        public AlipayModel alipay;

        public static class FirendsZoneModel {
            public String thumbnail;
            public String link;
            public String content;
        }

        public static class WechatModel {
            public boolean isMini;
            public String pagePath;
            public String userName;
            public String title;
            public String thumbnail;
            public String link;
            public String content;
        }

        public static class MobileQQModel {
            public String title;
            public String thumbnail;
            public String link;
            public String content;

        }

        public static class AlipayModel {
            public String title;
            public String thumbnail;
            public String link;
            public String content;

        }
    }

}
