package com.duoweidu.model.fyb;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductIteminfoData {

    public int id;
    public int source_type;
    public int product_id;
    public int merchant_id;
    public String name;
    public int price;
    public int old_price;
    public String thumbnail;
    public int market_price;
    public int lowest_price;
    public String seller_time;
    public String expired_date;
    public String manufactured_date;
    public int enabled;
    public int liked_cnt;
    public int ugc_cnt;
    public int selled_cnt;
    public String created_at;
    public String updated_at;
    public String merchant_item_code;
    public int actived;
    public int weight;
    public int audit_status;
    public String audit_time;
    public String online_time;
    public int offline_time;
    public int restriction_amount;
    public int fpostage_amount;
    public int only_new_user;
//    public String last_update;
    public int delete_flag;
//    public String feature;
    public int priority;
    public String apply_audit_time;
    public int lowest_web_price;
    public int version_id;
    public int deductible_rate;
    public int return_rate;
    public int buy_limit_amount;
    public ArrayList<AttrsModel> attrs;
    public int isShowRedBag;
    public int redBagMoney;
    public String promotionName;
    public boolean canBuy;
    public int total_cart_sku_cnt;
    public int fullExchange;
    public String reversion;
    public String deduction;
    public ArrayList<AttrListModel> attrList;
//    public HashMap<String, StocksListModel> stocksList;
    public int has_stock;
    public boolean canDelivery;
    public String deliveryWayName;
    public ArrayList<String> editorComment;
    public ArrayList<BatchOptionsModel> batchOptions;
    public ArrayList<AttrOptionsModel> attrOptions;
    public String batch;
    public int sourceType;
    public int productId;
    public int merchantId;
    public int left_stock;
    public ArrayList<String> ugcBrief;
    public String offline_before_expired;
    public String description;
    public boolean is_like;
    public String pics;
    public ArrayList<LabelsModel> labels;
//    public String unit;
    public MerchantInfoModel merchantInfo;
    public String graphicDetail;
    public ShareInfoModel shareInfo;
    public int skuIds;
    public String pricePrefix;
    public int selectedValue;
    public String schema;
    public String h5Link;
    public ArrayList<CommonRecommendproductsData.HasReturnListModel> hasReturnList;
    public int is_new_user;
    public String share_image;

    public static class AttrListModel {
        public int attrId;
        public String attrName;
        public ArrayList<AttrValuesModel> attrValues;

        public static class AttrValuesModel {
            public int id;
            public String value;
        }
    }

    public static class AttrsModel {
        public String name;
        public String value;
    }

//    public static class StocksListModel {
//        public int id;
//        public int source_type;
//        public int product_id;
//        public int merchant_id;
//        public String name;
//        public int price;
//        public int old_price;
//        public String thumbnail;
//        public int market_price;
//        public int lowest_price;
//        public int seller_time;
//        public String expired_date;
//        public String manufactured_date;
//        public int enabled;
//        public int liked_cnt;
//        public int ugc_cnt;
//        public int selled_cnt;
//        public String created_at;
//        public String updated_at;
//        public String merchant_item_code;
//        public int actived;
//        public int weight;
//        public int audit_status;
//        public String audit_time;
//        public String online_time;
//        public String offline_time;
//        public int restriction_amount;
//        public int fpostage_amount;
//        public int only_new_user;
//        public String last_update;
//        public int delete_flag;
//        public String feature;
//        public int priority;
//        public int apply_audit_time;
//        public int lowest_web_price;
//        public int version_id;
//        public int deductible_rate;
//        public int return_rate;
//        public int buy_limit_amount;
//        public String reversion;
//        public String deduction;
//        public int left_stock;
//
//
//    }

    public static class BatchOptionsModel {
        public String batch;
        public int skuId;
        public int price;
        public String expired_date;
        public String manufactured_date;
        public String seller_time;
        public int lowest_price;
        public String offline_before_expired;
    }

    public static class AttrOptionsModel {
        public String name;
        public ArrayList<ListModel> list;

        public static class ListModel {
            public String value;
            public int skuId;
        }
    }

    public static class LabelsModel {
        public String icon;
        public String text;
        public String link;
    }

    public static class MerchantInfoModel {
        public int id;
        public int roles;
        public String name;
        public String tinyurl;
        public String logo;
        public String description;
        public int online_sku_cnt;
        public int enabled;
        public int is_free_base_weight;
        public String notice;
        public String udesk_merchant_id;
        public ArrayList<LabelsModel1> labels;
        public ArrayList<String> activities;
        public String province;
        public String city;
        public String schema;

        public static class LabelsModel1 {
            public String icon;
            public String text;
        }
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
