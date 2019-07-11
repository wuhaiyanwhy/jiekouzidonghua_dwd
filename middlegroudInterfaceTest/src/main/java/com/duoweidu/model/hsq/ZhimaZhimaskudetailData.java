package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ZhimaZhimaskudetailData {

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
    public ArrayList<ProductCoupleskudetailData.AttrsModel> attrs;
    public int zhima_id;
    public int sku_id;
    public int show_price;
    public String zm_sku_name;
    public int row_status;
    public int enable;
    public int start_time;
    public int end_time;
    public int pin_id;
    public String discount;
    public int discount_percent;
    public String discount_text;
    public boolean skuIsOnline;
    public int zhima_price;
    public int participate_status;
    public String promotionName;
    public boolean canBuy;
    public boolean canDelivery;
    public String deliveryWayName;
    public ArrayList<ProductCoupleskudetailData.AttrKeysModel> attrKeys;
    public ArrayList<ProductCoupleskudetailData.AttrDatasModel> attrDatas;
    public ArrayList<String> editorComment;
    public ArrayList<BatchOptionsModel> batchOptions;
    public ArrayList<ProductCoupleskudetailData.AttrOptionsModel> attrOptions;
    public String batch;
    public int sourceType;
    public int skuId;
    public int productId;
    public int merchantId;
    public int left_stock;
    public ProductCoupleskudetailData.UgcBriefModel ugcBrief;
    public int offline_before_expired;
    public String description;
    public boolean is_like;
    public ArrayList<String> pics;
    public ArrayList<ProductCoupleskudetailData.LabelsModel> labels;
    public String unit;
    public ProductCoupleskudetailData.MerchantInfoModel merchantInfo;
    public ProductCoupleskudetailData.ShareInfoModel shareInfo;
    public int maxCartSkuCnt;
    public int remainderCartSkuCnt;
    public int skuIds;
    public String pricePrefix;
    public int selectedValue;
    public ArrayList<ActivityListModel> activity_list;

    public static class BatchOptionsModel {
        public String batch;
        public int skuId;
        public int price;
        public String expired_date;
        public String manufactured_date;
        public String seller_time;
        public int lowest_price;
        public int offline_before_expired;
    }

    public static class ActivityListModel {
        public int activity_id;
        public String activity_name;
        public String real_name;
        public String activity_no;
        public int rule_type;
        public String rules;
        public int discount;
        public String consumed_rules;

    }
}
