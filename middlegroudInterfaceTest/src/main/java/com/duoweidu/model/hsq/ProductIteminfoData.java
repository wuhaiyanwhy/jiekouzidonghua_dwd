package com.duoweidu.model.hsq;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductIteminfoData {

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
    public String seller_time;
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
    public ArrayList<AttrsModel> attrs;
    public int promotionName;
    public boolean canBuy;
    public ArrayList<AttrKeysModel> attrKeys;
    public HashMap<String, ProductCoupleskudetailData.AttrDatasModel>  attrDatas;
    public ArrayList<AttrKeysModel> attr_keys;
    public HashMap<String, ProductCoupleskudetailData.AttrDatasModel> attr_datas;
    public boolean canDelivery;
    public String deliveryWayName;
    public ArrayList<String> editorComment;
    public ArrayList<BatchOptionsModel> batchOptions;
    public ArrayList<AttrOptionsModel> attrOptions;
    public String batch;
    public int sourceType;
    public int skuId;
    public int productId;
    public int merchantId;
    public int left_stock;
    public int max_cart_nums;
    public ArrayList<String> ugcBrief;
    public int offline_before_expired;
    public String description;
    public boolean is_like;
    public int merchant_type;
    public ArrayList<String> pics;
    public ArrayList<ProductCoupleskudetailData.LabelsModel> labels;
    public String unit;
    public ProductCoupleskudetailData.MerchantInfoModel merchantInfo;
    public ProductCoupleskudetailData.ShareInfoModel shareInfo;
    public int skuIds;
    public int maxCartSkuCnt;
    public int remainderCartSkuCnt;
    public String pricePrefix;
    public int selectedValue;
    public String schema;
    public String h5Link;


    public static class AttrsModel {
        public String name;
        public String value;
    }

    public static class  AttrKeysModel {
        public ArrayList<String> list;
        public String name;
        public String defaultAttr;

    }

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

    public static class AttrOptionsModel {
        public String name;
        public ArrayList<ListModel> list;

        public static class ListModel {
            public String value;
            public int skuId;
        }
    }

}
