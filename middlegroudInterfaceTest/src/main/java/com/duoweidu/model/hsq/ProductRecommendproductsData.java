package com.duoweidu.model.hsq;

import java.util.ArrayList;

public class ProductRecommendproductsData {

    public ArrayList<ListModel> list;

    public static class ListModel {
        public int id;
        public int source_type;
        public String name;
        public String gc_cate_ids;
        public int lowest_price;
        public int highest_price;
        public int market_price;
        public int merchant_id;
        public int selled_cnt;
        public int ugc_cnt;
        public int liked_cnt;
        public int enabled;
        public String thumbnail;
        public int package_type;
        public int brand_id;
        public String producing_area;
        public int offline_before_expired;
        public int priority;
        public int today_discount;
        public int delivery_time_after_buy;
        public String description;
        public int restriction_amount;
        public int seller_time;
        public int weight;
        public int is_migrate;
        public ArrayList cates;
        public ArrayList<TagsModel> tags;
        public SkuInfoModel skuInfo;
        public int merchantId;

        public static class TagsModel {
            public String text;
            public String background;
        }

        public static class SkuInfoModel {
            public int skuId;
            public String skuPic;
            public String skuThumbnail;
            public ArrayList<ProductCoupleskudetailData.AttrsModel> attrs;
            public int left_stock;
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
            public String created_at;
            public String updated_at;
            public int audit_status;
            public String audit_time;
            public int restriction_amount;
            public int fpostage_amount;
            public String online_time;
            public int only_new_user;
            public String feature;
            public int lowest_web_price;
            public int version_id;
            public String marketPriceCert;
            public String marketPriceUrl;
            public String updateAt;
            public int merchantId;
            public int productId;
            public int offline_before_expired;
            public int sourceType;

        }



    }
}
